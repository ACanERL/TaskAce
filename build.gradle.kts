buildscript {
    val agp_version by extra("7.4.2")
    dependencies {
        val nav_version = "2.6.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id ("androidx.navigation.safeargs") version "2.5.3" apply false
    id ("com.google.dagger.hilt.android")version "2.44" apply false
}