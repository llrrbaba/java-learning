> log4j doc
> http://logging.apache.org/log4j/1.2/manual.html

> slf4j doc
> http://www.slf4j.org/manual.html

> If you wish to use log4j as the underlying logging framework, all you need to do is to declare "org.slf4j:slf4j-log4j12" as a dependency in your pom.xml file as shown below. In addition to slf4j-log4j12-1.7.28.jar, this will pull slf4j-api-1.7.28.jar as well as log4j-1.2.17.jar into your project. Note that explicitly declaring a dependency on log4j-1.2.17.jar or slf4j-api-1.7.28.jar is not wrong and may be necessary to impose the correct version of said artifacts by virtue of Maven's "nearest definition" dependency mediation rule.
