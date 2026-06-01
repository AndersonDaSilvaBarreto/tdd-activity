@ApplicationModule(
        displayName = "Post Module",
        allowedDependencies = {"user :: api", "user :: events"}

)
package com.agile_development.tdd_activity.post;
import org.springframework.modulith.ApplicationModule;