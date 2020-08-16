package com.company.e_Generic_Data_Structures;

import java.util.Objects;

public class Student implements Comparable<Student>{
    
    private String name;
    private int score;
    
    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object otherStudent) {
        // check
        if (this == otherStudent) return true;
        if (otherStudent == null) return false;
        if (this.getClass() != otherStudent.getClass()) return false;
        Student other = (Student)otherStudent;
        // judge score
        return this.score == other.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Student other) {
        // 升序
        //return this.score - other.score;
        // 降序
        return other.score - this.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)",this.name,this.score);
    }
}
