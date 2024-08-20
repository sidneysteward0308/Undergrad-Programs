<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #26fed2;}
</style>
<link href="form.css" rel="stylesheet">
</head>
<body>  

<?php
// define variables and set to empty values
$positionappliedforErr = $nameErr = $genderErr = $nationalityErr = $dateofbirthErr = $addressErr
= $telephonenumberErr = $emailErr = $educationalhistoryErr = $yearsofexperienceErr
= $personalstatementErr = $referee2nameErr = $referee2occupationErr = $referee1relationshipErr
= $referee2addressErr = $referee2phoneErr = $vegetarianErr = $selectedfruitsErr = "";

$positionappliedfor = $name = $gender = $nationality = $dateofbirth = $address
= $telephonenumber = $email = $educationalhistory = $yearsofexperience
= $personalstatement = $referee2name = $referee2occupation = $referee1relationship
= $referee2address = $referee2phone = $vegetarian = $selectedfruits = "";

function alertPopUp() {
	echo '<script>alert("Are you sure do you want to submit? Changes cant be edited further")</script>';  
	}   if ($_SERVER["REQUEST_METHOD"] == "POST") 
	{     alertPopUp();
	}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["positionappliedfor"])) {
    $positionappliedforErr = "Position is required";
  } else {
    $positionappliedfor = test_input($_POST["positionappliedfor"]);
    // check if name only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z-' ]*$/",$positionappliedfor)) {
      $positionappliedforErr = "Only letters and white space allowed";
    }
  }
    if (empty($_POST["name"])) {
    $nameErr = "Name is required";
  } else {
    $name = test_input($_POST["name"]);
    // check if name only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
      $nameErr = "Only letters and white space allowed";
    }
  }
    if (empty($_POST["gender"])) {
    $genderErr = "Gender is required";
  } else {
    $gender = test_input($_POST["gender"]);
  }
  
  if (empty($_POST["nationality"])) {
    $nationalityErr = "nationality is required";
  } else {
    $nationality = test_input($_POST["nationality"]);
    // check if nationality only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z-' ]*$/",$nationality)) {
      $nationalityErr = "Only letters and white space allowed";
    }
  }
      if (empty($_POST["dateofbirth"])) {
    $dateofbirthErr = "Date of Birth is required";
  } else {
    $dateofbirth = test_input($_POST["dateofbirth"]);
  }
    if (empty($_POST["address"])) {
    $addressErr = "Address is required";
  } else {
    $address = test_input($_POST["address"]);
    // check if address only contains letters and whitespace
    if (!preg_match('/^(?:\\d+ [a-zA-Z ]+, ){2}[a-zA-Z ]+$/', $address)) {
      $addressErr = "Valid address only.";
    }
}
  if (empty($_POST["telephonenumber"])) {
    $telephonenumberErr = "Phone Number is required";
  } else {
    $telephonenumber = test_input($_POST["telephonenumber"]);
    // check if telephonenumber only contains letters and whitespace
    if (!preg_match('^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$ ',$telephonenumber)) {
      $telephonenumberErr = "Only numbers allowed";
    }
  }
  
  if (empty($_POST["email"])) {
    $emailErr = "Email is required";
  } else {
    $email = test_input($_POST["email"]);
    // check if e-mail address is well-formed
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $emailErr = "Invalid email format";
    }
  }
    if (empty($_POST["personalstatement"])) {
    $personalstatement = "";
  } else {
    $personalstatement = test_input($_POST["personalstatement"]);
  }
      if (empty($_POST["educationalhistory"])) {
    $educationalhistory = "";
  } else {
    $educationalhistory = test_input($_POST["educationalhistory"]);
  }
}
 

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>

<h2>Job Application</h2>
<p><span class="error">* required field</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
  Name: <input type="text" name="name" value="<?php echo $name;?>">
  <span class="error">* <?php echo $nameErr;?></span>
  <br><br>
  Gender:
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?> value="female">Female
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="male") echo "checked";?> value="male">Male
    <input type="radio" name="gender" <?php if (isset($gender) && $gender=="nonbinary") echo "checked";?> value="nonbinary">Nonbinary 
  <input type="radio" name="gender" <?php if (isset($gender) && $gender=="other") echo "checked";?> value="other">Other  
  <span class="error">* <?php echo $genderErr;?></span>
  <br><br>
  Nationality: <input type="text" name="nationality" value="<?php echo $nationality;?>">
  <span class="error">* <?php echo $nationalityErr;?></span>
  <br><br>
  Date of Birth: <input type="date" placeholder="YYYY-MM-DD" name="dateofbirth" value="" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required="required">
  <br><br>
  Address: <input type="text" name="address" value="<?php echo $address;?>">
  <span class="error">* <?php echo $addressErr;?></span>
  <br><br>
  Phone Number: <input type="text" name="telephonenumber" value="<?php echo $telephonenumber;?>">
  <span class="error">* <?php echo $telephonenumberErr;?></span>
  <br><br>
  E-mail: <input type="text" name="email" value="<?php echo $email;?>">
  <span class="error">* <?php echo $emailErr;?></span>
  <br><br>
  Educational History and Qualifications: <textarea name="educationalhistory" rows="5" cols="40"><?php echo $educationalhistory;?></textarea>
  <br><br>
  Personal Statement: <textarea name="personalstatement" rows="5" cols="40"><?php echo $personalstatement;?></textarea>
  <br><br>
  <input type="submit" name="submit" value="Submit">  
</form>


<?php
echo "<h2>Your Input:</h2>";
echo $positionappliedfor;
echo "<br>";
echo $name;
echo "<br>";
echo $gender;
echo "<br>";
echo $nationality;
echo "<br>";
echo $dateofbirth;
echo "<br>";
echo $address;
echo "<br>";
echo $telephonenumber;
echo "<br>";
echo $email;
echo "<br>";
echo $educationalhistory;
echo "<br>";
echo $yearsofexperience;
echo "<br>";
echo $personalstatement;
echo "<br>";
echo $referee2name;
echo "<br>";
echo $referee2occupation;
echo "<br>";
echo $referee1relationship;
echo "<br>";
echo $referee2address;
echo "<br>";
echo $referee2phone;
echo "<br>";
echo $vegetarian;
echo "<br>";
echo $selectedfruits;
echo "<br>";
?>

</body>
</html>
