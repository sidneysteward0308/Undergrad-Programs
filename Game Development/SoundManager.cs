using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SoundManager : MonoBehaviour
{
    public static SoundManager Instance { get; set; }

    public AudioSource PistolShot;
    public AudioSource PistolEmptyMag;
    public AudioSource PistolReload;

    public AudioSource ZombieChannel;
    public AudioClip zombiePatrol;
    public AudioClip zombieChase;
    public AudioClip zombieAttack;
    public AudioClip zombieHurt;
    public AudioClip zombieDeath;

    public AudioSource PlayerChannel;
    public AudioClip playerHurt;
    public AudioClip playerDeath;

    public AudioClip gameOverMusic;

    public AudioSource backgroundMusic;


    private void Awake()
    {
        if (Instance != null && Instance != this)
        {
            Destroy(gameObject);
        }
        else
        {
            Instance = this;
        }
    }
}

