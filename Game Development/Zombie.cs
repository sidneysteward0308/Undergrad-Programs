using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class Zombie : MonoBehaviour
{
    public ZombieHead zombieHead;

    public int zombieDamage;

    private void Start()
    {
        zombieHead.damage = zombieDamage;
    }
}
