using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class InteractionManager : MonoBehaviour
{
    public static InteractionManager Instance { get; set; }

    public Weapon hoveredWeapon = null;
    public AmmoBox hoveredAmmoBox = null;
    public Letter hoveredLetter = null;
    public Flashlight hoveredFlashlight = null;
    public Batteries hoveredBatteries = null;
    public Camcorder hoveredCamcorder = null;

    [SerializeField] TMP_Text UItext;

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

    private void Update()
    {
        Ray ray = Camera.main.ViewportPointToRay(new Vector3(0.5f, 0.5f, 0));
        RaycastHit hit;

        if (Physics.Raycast(ray, out hit))
        {
            GameObject objectHitByRaycast = hit.transform.gameObject;

            if (objectHitByRaycast.GetComponent<Weapon>() && objectHitByRaycast.GetComponent<Weapon>().isActiveWeapon == false)
            {
                // Disable the outline of the previously selected item
                if (hoveredWeapon)
                {
                    //UItext.text = (" ");
                    hoveredWeapon.GetComponent<Outline>().enabled = false;
                }

                UItext.text = ("Left mouse to shoot.") + Environment.NewLine + ("R to reload.");
                hoveredWeapon = objectHitByRaycast.gameObject.GetComponent<Weapon>();
                hoveredWeapon.GetComponent<Outline>().enabled = true;
                

                if (Input.GetKeyDown(KeyCode.E))
                {
                    WeaponManager.Instance.PickupWeapon(objectHitByRaycast.gameObject);
                }
            }
            else
            {
                if (hoveredWeapon)
                {
                    //UItext.text = (" ");
                    hoveredWeapon.GetComponent<Outline>().enabled = false;
                }
            }

            // Ammo Box
            if (objectHitByRaycast.GetComponent<AmmoBox>())
            {
                // Disable the outline of the previously selected item
                if (hoveredAmmoBox)
                {
                    //UItext.text = (" ");
                    hoveredAmmoBox.GetComponent<Outline>().enabled = false;
                }

                hoveredAmmoBox = objectHitByRaycast.gameObject.GetComponent<AmmoBox>();
                hoveredAmmoBox.GetComponent<Outline>().enabled = true;

                if (Input.GetKeyDown(KeyCode.E))
                {
                    WeaponManager.Instance.PickupAmmo(hoveredAmmoBox);
                    Destroy(objectHitByRaycast.gameObject);
                }
            }
            else
            {
                if (hoveredAmmoBox)
                {
                    //UItext.text = (" ");
                    hoveredAmmoBox.GetComponent<Outline>().enabled = false;
                }
            }

            // Letter
            if (objectHitByRaycast.GetComponent<Letter>())
            {
                // Disable the outline of the previously selected item
                if (hoveredLetter)
                {
                    //UItext.text = (" ");
                    hoveredLetter.GetComponent<Outline>().enabled = false;
                }

                hoveredLetter = objectHitByRaycast.gameObject.GetComponent<Letter>();
                hoveredLetter.GetComponent<Outline>().enabled = true;

                if (Input.GetKeyDown(KeyCode.E))
                {
                    Letter.Instance.ReadLetter(objectHitByRaycast.gameObject);
                }
            }
            else
            {
                if (hoveredLetter)
                {
                    //UItext.text = (" ");
                    hoveredLetter.GetComponent<Outline>().enabled = false;
                }
            }

            // Flashlight
            if (objectHitByRaycast.GetComponent<Flashlight>())
            {
                // Disable the outline of the previously selected item
                if (hoveredFlashlight)
                {
                    //UItext.text = (" ");
                    hoveredFlashlight.GetComponent<Outline>().enabled = false;
                }
                UItext.text = ("Press F to toggle Flashlight.") + Environment.NewLine + ("Press Q to Reload Batteries.");
                hoveredFlashlight = objectHitByRaycast.gameObject.GetComponent<Flashlight>();
                hoveredFlashlight.GetComponent<Outline>().enabled = true;
              

                if (Input.GetKeyDown(KeyCode.E))
                {
                    Flashlight.Instance.SetPickedUp();
                    Flashlight.Instance.FlashlightOn(objectHitByRaycast.gameObject);
                    MeshRenderer mr = objectHitByRaycast.GetComponent<MeshRenderer>();
                    CapsuleCollider bc = objectHitByRaycast.GetComponent<CapsuleCollider>();
                    mr.enabled = false;
                    bc.enabled = false;
                }
            }
            else
            {
                if (hoveredFlashlight)
                {
                    //UItext.text = (" ");
                    hoveredFlashlight.GetComponent<Outline>().enabled = false;
                }
            }

            // Batteries
            if (objectHitByRaycast.GetComponent<Batteries>())
            {
                // Disable the outline of the previously selected item
                if (hoveredBatteries)
                {
                    //UItext.text = (" ");
                    hoveredBatteries.GetComponent<Outline>().enabled = false;
                }

                hoveredBatteries = objectHitByRaycast.gameObject.GetComponent<Batteries>();
                hoveredBatteries.GetComponent<Outline>().enabled = true;

                if (Input.GetKeyDown(KeyCode.E))
                {
                    Batteries.Instance.PickupBatteries(objectHitByRaycast.gameObject);
                    Destroy(objectHitByRaycast.gameObject);
                }
            }
            else
            {
                if (hoveredBatteries)
                {
                    //UItext.text = (" ");
                    hoveredBatteries.GetComponent<Outline>().enabled = false;
                }
            }

            // Camcorder/NightVision
            // Batteries
            if (objectHitByRaycast.GetComponent<Camcorder>())
            {
                // Disable the outline of the previously selected item
                if (hoveredCamcorder)
                {
                    //UItext.text = (" ");
                    hoveredCamcorder.GetComponent<Outline>().enabled = false;
                }

                hoveredCamcorder = objectHitByRaycast.gameObject.GetComponent<Camcorder>();
                hoveredCamcorder.GetComponent<Outline>().enabled = true;

                if (Input.GetKeyDown(KeyCode.E))
                {
                    Camcorder.Instance.PickUpCamcorder(objectHitByRaycast.gameObject);
                    Destroy(objectHitByRaycast.gameObject);
                }
            }
            else
            {
                if (hoveredCamcorder)
                {
                    //UItext.text = (" ");
                    hoveredCamcorder.GetComponent<Outline>().enabled = false;
                }
            }
        }
    }
}
