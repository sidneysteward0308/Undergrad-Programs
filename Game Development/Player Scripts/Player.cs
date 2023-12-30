using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Player : MonoBehaviour
{
    public int HP = 5;
    public GameObject bloodyScreen;

    public TextMeshProUGUI playerLivesUI;
    public GameObject gameOverUI;
    public GameObject youWinUI;
    public Canvas staticCameraUI;

    public bool isDead;
    public bool keyCollected = false;

    private void Start()
    {
        playerLivesUI.text = $"HEALTH: {HP}";
    }

    private void Update()
    {
        if (keyCollected == true)
        {
            // Start the fade effect
            GetComponent<ScreenFader>().StartFade();
            staticCameraUI.gameObject.SetActive(false);

            // Start the coroutine to show the "You Win" UI
            StartCoroutine(ShowYouWinUI());
        }
    }

    bool AreAllEnemiesDead()
    {
        GameObject[] enemies = GameObject.FindGameObjectsWithTag("Enemy");

        foreach (GameObject enemyObject in enemies)
        {
            Enemy enemy = enemyObject.GetComponent<Enemy>();
            if (enemy == null || !enemy.isDead)
            {
                return false; // At least one enemy is alive
            }
        }

        return true; // All enemies are dead
    }

    IEnumerator ShowYouWinUI()
    {
        yield return new WaitForSeconds(1f);
        youWinUI.SetActive(true); // Show the "You Win" UI
    }

    bool HasCrossedGate()
    {
        Collider[] colliders = Physics.OverlapSphere(transform.position, 1.0f);
        foreach (Collider collider in colliders)
        {
            if (collider.CompareTag("Endpoint"))
            {
                return true;
            }
        }
        return false;
    }


    public void TakeDamage(int damageAmount)
    {
        HP -= damageAmount;

        if (HP <= 0)
        {
            print("Player Dead");
            PlayerDead();
            isDead = true;
        }
        else
        {
            print("Player Hit");
            StartCoroutine(BloodyScreenEffect());
            playerLivesUI.text = $"HEALTH: {HP}";
            SoundManager.Instance.PlayerChannel.PlayOneShot(SoundManager.Instance.playerHurt);
        }
    }

    private void PlayerDead()
    {
        SoundManager.Instance.PlayerChannel.PlayOneShot(SoundManager.Instance.playerDeath);
        SoundManager.Instance.backgroundMusic.Stop();
        SoundManager.Instance.PlayerChannel.clip = SoundManager.Instance.gameOverMusic;
        SoundManager.Instance.PlayerChannel.PlayDelayed(2f);

        GetComponentInChildren<MouseMovement>().enabled = false;
        GetComponent<PlayerMovement>().enabled = false;

        // Dying Animation
        GetComponentInChildren<Animator>().enabled = true;
        playerLivesUI.gameObject.SetActive(false);
        staticCameraUI.gameObject.SetActive(false);

        GetComponent<ScreenFader>().StartFade();
        StartCoroutine(ShowGameOverUI());
    }

    private IEnumerator ShowGameOverUI()
    {
        yield return new WaitForSeconds(1f);
        gameOverUI.gameObject.SetActive(true);
        yield return new WaitForSeconds(2f);
        GetComponentInChildren<MouseMovement>().enabled = true;
        Cursor.visible = true;
        SceneManager.LoadScene("Main Menu");
    }

    
    private IEnumerator BloodyScreenEffect()
    {
        if (bloodyScreen.activeInHierarchy == false)
        {
            bloodyScreen.SetActive(true);
        }

        var image = bloodyScreen.GetComponentInChildren<Image>();

        // Set the initial alpha value to 1 (fully visible).
        Color startColor = image.color;
        startColor.a = 1f;
        image.color = startColor;

        float duration = 2f;
        float elapsedTime = 0f;

        while (elapsedTime < duration)
        {
            // Calculate the new alpha value using Lerp.
            float alpha = Mathf.Lerp(1f, 0f, elapsedTime / duration);

            // Update the color with the new alpha value.
            Color newColor = image.color;
            newColor.a = alpha;
            image.color = newColor;

            // Increment the elapsed time.
            elapsedTime += Time.deltaTime;

            yield return null; ; // Wait for the next frame.
        }

        if (bloodyScreen.activeInHierarchy)
        {
            bloodyScreen.SetActive(false);
        }
    }
    
    private void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("ZombieHead"))
        {
            if (isDead == false)
            {
                TakeDamage(other.gameObject.GetComponent<ZombieHead>().damage);
            }
        }

        if(other.CompareTag("Key"))
        {
            keyCollected = true;
        }
    }
}
