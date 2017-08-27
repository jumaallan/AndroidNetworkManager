# Android Network Manager

A Simple Android library to check various types of network connections, to allow an app check internet connectivity status before making HTTP Requests.

## Getting Started

These instructions will help you set up this library easily on your current project and working in no time. You only need a few configurations to start working!

### Installing

A step by step to set up Android Network Manager in your project.

First, we need to add this permission to our Android Manifest file :

```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

If you are using this Library, this means your Application is using Internet, so don't forget the following permission also:

```
<uses-permission android:name="android.permission.INTERNET"/>
```

That's it, you have set up the required permissions and ready to go!

## Add gradle dependency

To be able to use the following library, you will need to add the following gradle dependency in your build.gradle(module:app) file

```
compile 'com.github.jumadeveloper:networkmanager:0.0.1'
```

Sync Project, and start using the library instantly on your project.

### Quick Example - Activity

When using in an Android Activity, use the following code snippet :

```
if (NetworkManager.getInstance(getApplicationContext()).isOnline()) {
            /**
             * Internet is available
             */
            Toast.makeText(this, "Mobile Networks | WiFi Connected!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ooops! No Mobile Networks | WiFi Connected!", Toast.LENGTH_SHORT).show();
        }
```

### Quick Example - Fragments

When using in an Android Fragments, use the following code snippet :

```
if (NetworkManager.getInstance(getActivity().getApplicationContext()).isOnline()) {
            /**
             * Internet is available
             */
            Toast.makeText(getActivity(), "Mobile Networks | WiFi Connected!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Ooops! No Mobile Networks | WiFi Connected!", Toast.LENGTH_SHORT).show();
        }
```

## Contributing and Issues

Please feel free to contribute or open issues, if any and I will be happy to help out!

## Authors

* **Juma Allan - Android Developer

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Juma Allan
