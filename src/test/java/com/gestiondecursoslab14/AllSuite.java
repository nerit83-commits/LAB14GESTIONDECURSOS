package com.gestiondecursoslab14;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
    CourseTest.class,
    OnlineCourseTest.class,
    OnsiteCourseTest.class
})
@IncludeTags({"setTitle"})
@ExcludeTags({"constructor"})
public class AllSuite {
    
}
