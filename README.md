# Currencyfy
[Android] [Java]   Converts number to readable currency format. Easy, error free &amp; highly compatible!
[![](https://jitpack.io/v/jpvs0101/Currencyfy.svg)](https://jitpack.io/#jpvs0101/Currencyfy)

currencyfy (500000.78); // $ 500,000.78  //default

currencyfy (500000.78, false); // $ 500,001 // hide fraction (will round off automatically!)

currencyfy (500000.78, false, false); // 500,001 // hide fraction & currency symbol

currencyfy (new Locale("en", "in"), 500000.78); // ₹ 5,00,000.78 // custom locale

<img src="https://github.com/jpvs0101/Currencyfy/blob/master/Screenshots/Screenshot_01.png" width="320">



<b>Wows:</b>
* Auto prettify (Automatically add space between currency symbol & number)
* Works correctly on older versions of Android
* Works correctly with RTL languages 


<br><b>To get a Git project into your build:</b>

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.jpvs0101:Currencyfy:v1.0.1'
	}




