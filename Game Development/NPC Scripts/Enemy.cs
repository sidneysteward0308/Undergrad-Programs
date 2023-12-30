using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class Enemy : MonoBehaviour
{
    [SerializeField] private int HP = 3;
    private Animator animator;

    private NavMeshAgent navAgent;

    public bool isDead;
    public GameObject zombieHead;
    public GameObject zombieBody;
    private SphereCollider sphereCollider;
    private CapsuleCollider zombieBodyCollider;

    private void Start()
    {
        animator = GetComponent<Animator>();
        navAgent = GetComponent<NavMeshAgent>();
        sphereCollider = zombieHead.GetComponent<SphereCollider>();
        zombieBodyCollider = zombieBody.GetComponent<CapsuleCollider>();
    }

    private void Update()
    {
        if (isDead == true)
        {
            if (sphereCollider != null)
            {
                sphereCollider.enabled = false;
            }

            if (zombieBodyCollider != null)
            {
                zombieBodyCollider.enabled = false;
            }
        }
    }

    public void TakeDamage(int damageAmount)
    {
        HP -= damageAmount;

        if (HP <= 0)
        {
            int randomValue = Random.Range(0, 2);
            if (randomValue == 0)
            {
                animator.SetTrigger("DIE1");
            }
            else
            {
                animator.SetTrigger("DIE2");
            }

            isDead = true;

            // Dead Sound
            SoundManager.Instance.ZombieChannel.PlayOneShot(SoundManager.Instance.zombieDeath);
        }
        else
        {
            animator.SetTrigger("DAMAGE");

            // Hurt Sound
            SoundManager.Instance.ZombieChannel.PlayOneShot(SoundManager.Instance.zombieHurt);
        }
    }

    private void OnDrawGizmos()
    {
        Gizmos.color = Color.red;
        Gizmos.DrawWireSphere(transform.position, 2.5f); // Attacking // Stop Attacking

        Gizmos.color = Color.blue;
        Gizmos.DrawWireSphere(transform.position, 6f); // Detection (Start chasing)

        Gizmos.color = Color.green;
        Gizmos.DrawWireSphere(transform.position, 15f); // Stop Chasing
    }
}
