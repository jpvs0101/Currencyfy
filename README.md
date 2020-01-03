# Currencyfy
[Android] [Java]   Converts number to readable currency format. Easy, error free &amp; highly compatible!

currencyfy (500000.78) -> $ 500,000.78

currencyfy (500000.78, false) -> $ 500,001

currencyfy (500000.78, false, false) -> 500,001

currencyfy (new Locale("en", "in"), 500000.78) -> ₹ 5,00,000.78

<img src="https://github.com/jpvs0101/Currencyfy/blob/master/Screenshots/Screenshot_01.png" width="320">


How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

    gradle
    maven
    sbt
    leiningen

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




