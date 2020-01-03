# Currencyfy
Converts number to readable currency format (with currency symbol & separator). Lite, easy, error free & highly compatible with older versions of Android!

[![](https://jitpack.io/v/jpvs0101/Currencyfy.svg)](https://jitpack.io/#jpvs0101/Currencyfy)

<img src="https://github.com/jpvs0101/Currencyfy/blob/master/Screenshots/Screenshot_01.png" width="320">

```
currencyfy (500000.78); // $ 500,000.78  //default

currencyfy (500000.78, false); // $ 500,001 // hide fraction (will round off automatically!)

currencyfy (500000.78, false, false); // 500,001 // hide fraction & currency symbol

currencyfy (new Locale("en", "in"), 500000.78); // ₹ 5,00,000.78 // custom locale
```

If we call `currencyfy ()` without passing locale, Currencyfy uses device locale. We can set default locale for Currencyfy globally by calling `Currencyfy.setDefaultLocale()`. 


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


License
-------

```
Copyright (C) 2020 Jayaprakash

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



