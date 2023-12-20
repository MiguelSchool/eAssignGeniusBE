package org.example.eassigngeniusbe.model.enumaration;

import lombok.Getter;

@Getter
public enum SchoolSubject {
    GERMAN("German"),
    MATHEMATICS("Mathematics"),
    BIOLOGY("Biology"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    HISTORY("History"),
    GEOGRAPHY("Geography"),
    SOCIAL_STUDIES("Social Studies"),
    POLITICS_ECONOMICS("Politics / Economics"),
    ART("Art"),
    MUSIC("Music"),
    PHYSICAL_EDUCATION("Physical Education"),
    TECHNOLOGY("Technology"),
    COMPUTER_SCIENCE("Computer Science"),
    RELIGIOUS_EDUCATION_ETHICS("Religious Education / Ethics"),
    ENGLISH("English"),
    FRENCH("French"),
    LATIN("Latin"),
    SPANISH("Spanish"),
    ITALIAN("Italian"),
    SPORTS("Sport"),
    OTHER_FOREIGN_LANGUAGES("Other Foreign Languages");

    private final String subjectName;

    SchoolSubject(String subjectName) {
        this.subjectName = subjectName;
    }
}
