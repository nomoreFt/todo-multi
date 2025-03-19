package com.nomoreft.todoapp;

import com.querydsl.codegen.GenericExporter;
import com.querydsl.codegen.Keywords;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

public class QuerydslGenerator {
    public static void main(String[] args) {
        GenericExporter exporter = new GenericExporter();
        exporter.setKeywords(Keywords.JPA);
        exporter.setEntityAnnotation(Entity.class);
        exporter.setEmbeddableAnnotation(Embeddable.class);
        exporter.setEmbeddedAnnotation(Embedded.class);
        exporter.setSupertypeAnnotation(MappedSuperclass.class);
        exporter.setTargetFolder(new File("src/main/generated"));
        Optional<Package> first = Arrays.stream(Package.getPackages())
                .filter(p -> p.getName().equals("com.nomoreft.todoapp"))
                .findFirst();
        exporter.export(first.get());
        System.out.println("Querydsl classes generated");
    }
}
