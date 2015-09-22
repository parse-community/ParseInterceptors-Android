[![Build Status][build-status-svg]][build-status-link]
[![Maven Central][maven-svg]][maven-link]
[![License][license-svg]][license-link]

A powerful tool that allows you to monitor the http requests and responses between Parse SDK and Parse Server.

For Parse and its features, see [the website][parse.com] and [getting started][guide].

## Download
Download [the latest JAR][latest] or define in Gradle:

```groovy
dependencies {
  ...
  debugCompile 'com.parse:parseinterceptors:0.0.1'
  // If you need okhttp library, make sure you use 2.5.0 or above
  // compile 'com.squareup.okhttp:okhttp:2.5.0'
}
```
If you are using okhttp library in your app, make sure you use version 2.5.0 or above.

## Usage

### Integrate with Parse and your app
Check our [wiki][wiki] about how to use `ParseLogInterceptor` and `ParseStethoInterceptor`, and write your own `ParseNetworkInterceptor`.

## How Do I Contribute?
We want to make contributing to this project as easy and transparent as possible. Please refer to the [Contribution Guidelines](CONTRIBUTING.md).

## License
    Copyright (c) 2015-present, Parse, LLC.
    All rights reserved.

    This source code is licensed under the BSD-style license found in the
    LICENSE file in the root directory of this source tree. An additional grant
    of patent rights can be found in the PATENTS file in the same directory.

 [wiki]: https://github.com/ParsePlatform/ParseInterceptors-Android/wiki
 [parse.com]: https://www.parse.com/products/android
 [guide]: https://www.parse.com/docs/android/guide
 [build-status-svg]: https://travis-ci.org/ParsePlatform/ParseInterceptors-Android.svg?branch=master
 [build-status-link]: https://travis-ci.org/ParsePlatform/ParseInterceptors-Android
 [maven-svg]: https://maven-badges.herokuapp.com/maven-central/com.parse/parseinterceptors/badge.svg?style=flat
 [maven-link]: https://maven-badges.herokuapp.com/maven-central/com.parse/parseinterceptors
 [license-svg]: https://img.shields.io/badge/license-BSD-lightgrey.svg
 [license-link]: https://github.com/ParsePlatform/ParseInterceptors-Android/blob/master/LICENSE
 [latest]: https://search.maven.org/remote_content?g=com.parse&a=parseinterceptors&v=LATEST