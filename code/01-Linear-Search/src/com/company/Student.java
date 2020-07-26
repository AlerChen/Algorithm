package com.company;

public class Student {
    private String name;
    public Student (String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object student) {
        // check null
        if (student == null) return false;
        // check the same object
        if (this == student) return true;
        // check the class
        if (this.getClass() != (student.getClass())) return false;

        Student innerStudent = (Student) student;
        if (this.name.toLowerCase().equals(innerStudent.name.toLowerCase()))return true;
        return false;
    }


}
