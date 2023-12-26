using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;


public class ClearText : MonoBehaviour
{
    [SerializeField] TMP_Text UItext;

    private void OnTriggerEnter(Collider other)
    {
        UItext.text = (" ");
    }
}
