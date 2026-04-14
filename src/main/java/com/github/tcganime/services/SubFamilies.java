package com.github.tcganime.services;

public class SubFamilies {

    public interface SubFamilyType {}

    public enum SubRace implements SubFamilyType {
        DRAGON, FLEAU, MONSTRE, DEMON, DIVIN, HUMAIN, HOMME_BETE, HEROS, VILAIN
    }

    public enum SubElementaire implements SubFamilyType {
        EAU, FEU, TERRE, TENEBRES, LUMIERE, ELECTRIQUE, NEANT
    }

    public enum SubPecheur implements SubFamilyType {
        GOURMANDISE, AVARICE, COLERE, ORGUEIL, LUXURE, PARESSE, JALOUSIE
    }

    public enum SubArchetype implements SubFamilyType {
        MAGE, COMBATTANT, EPEISTE, ARCHER, TRAVAILLEUR
    }
}