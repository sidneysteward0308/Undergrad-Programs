using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Threading;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
using static System.Net.Mime.MediaTypeNames;

public class PauseMenu : MonoBehaviour
{
    [SerializeField] public GameObject CanvasObject;
    public bool isPaused;

    void Start()
    {
        CanvasObject.GetComponent<Canvas>().enabled = false;
    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            if (isPaused)
            {
                ContinueGame();
            }
            else
            {
                PauseGame();
            }
        }
    }

    public void GoToScene(string sceneName)
    {
        SceneManager.LoadScene(sceneName);
    }

    public void ContinueGame()
    {
        Cursor.lockState = CursorLockMode.Locked;
        Cursor.visible = false;
        CanvasObject.GetComponent<Canvas>().enabled = false;
        Time.timeScale = 1f;
        isPaused = false;
    }

    public void PauseGame()
    {
        Cursor.lockState = CursorLockMode.None;
        Cursor.visible = true;
        CanvasObject.GetComponent<Canvas>().enabled = true;
        Time.timeScale = 0f;
        isPaused = true;
    }
}
