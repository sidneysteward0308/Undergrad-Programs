using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    public int bulletDamage;

    private void OnCollisionEnter(Collision objectHit)
    {
        if (objectHit.gameObject.CompareTag("Target"))
        {
            print("hit " +  objectHit.gameObject.name + " !");
            CreateBulletImpactEffect(objectHit);
            Destroy(gameObject);
        }

        if (objectHit.gameObject.CompareTag("Enemy"))
        {
            print("hit " + objectHit.gameObject.name + " !");
            if (objectHit.gameObject.GetComponent<Enemy>().isDead == false)
            {
                objectHit.gameObject.GetComponent<Enemy>().TakeDamage(bulletDamage);
            }
            CreateBloodSprayEffect(objectHit);
            Destroy(gameObject);
        }
    }

    void CreateBulletImpactEffect(Collision objectHit)
    {
        ContactPoint contact = objectHit.contacts[0];

        GameObject hole = Instantiate(
            GlobalReferences.Instance.bulletImpactEffectPrefab,
            contact.point,
            Quaternion.LookRotation(contact.normal)
            );

        hole.transform.SetParent(objectHit.gameObject.transform);
    }

    private void CreateBloodSprayEffect(Collision objectHit)
    {
        ContactPoint contact = objectHit.contacts[0];

        GameObject bloodSprayPrefab = Instantiate(GlobalReferences.Instance.bloodSprayEffect, contact.point, Quaternion.LookRotation(contact.normal));

        bloodSprayPrefab.transform.SetParent(objectHit.gameObject.transform);
    }

}
