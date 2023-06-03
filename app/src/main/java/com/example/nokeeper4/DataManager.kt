package com.example.nokeeper4

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init{
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents","Android Programming with Intents")
        courses.set(course.courseId, course)
        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses.set(course.courseId, course)
        course = CourseInfo("java_lang", "Java Fundamentals: The Java Language")
        courses.set(course.courseId, course)
        course = CourseInfo("java_core", "Java Fundamentals: The core platform")
        courses.set(course.courseId, course)
    }
    private fun initializeNotes() {
        val note1 = NoteInfo()
        note1.title = "Note 1"
        note1.text = "This is the first note."
        note1.course = courses["android_intents"] ?: throw IllegalArgumentException("Course not found")

        val note2 = NoteInfo()
        note2.title = "Note 2"
        note2.text = "This is the second note."
        note2.course = courses["android_async"] ?: throw IllegalArgumentException("Course not found")

        notes.add(note1)
        notes.add(note2)
    }
}