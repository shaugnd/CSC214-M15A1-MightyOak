package edu.csc214.mightyoak;

import java.util.Objects;

/**
 * Represents a squirrel stored in a binary tree node.
 */
public final class Squirrel {
    // This file is super simple it doesn't do much.
    private final String name;

    public Squirrel(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null.");
    }

    public String getName() {
        return name;
    }
}
