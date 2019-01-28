# demo
Repository contains the branches with code examples for some use cases.
You can undestand, what concrete code example contain is, by the branches name.


## sonar_qube branch

Branch contain commits with example, how to enable the [Jacoco](https://docs.gradle.org/4.10/userguide/jacoco_plugin.html) plugin.
You should pay attenntion for Kotlin classes, because the bytecode for the Java classes, and bytecode for Kotlin classes is generated in different places.
Also, then include the [SonarQube](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Gradle) plugin.
For dispaying the Kotlin classes coverage should include [sonar-kotlin](https://github.com/arturbosch/sonar-kotlin) plugin. Because the official plugin for Kotlin do not allows displaying Kotlin class coverage.  

Also, good help is [post](https://android.jlelse.eu/sonarqube-code-coverage-for-kotlin-on-android-with-bitrise-71b2fee0b797)



