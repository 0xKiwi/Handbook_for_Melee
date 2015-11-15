package com.thatkawaiiguy.meleehandbook.other;

public class FrameDataHelper {
    public static String setShortMovePicked(String move) {
        switch(move) {
            case "Down Aerial":
                return "dair";
            case "Forward Aerial":
                return "fair";
            case "Neutral Aerial":
                return "nair";
            case "Up Aerial":
                return "uair";
            case "Back Aerial":
                return "bair";
            case "Jab 1":
                return "jabone";
            case "Jab 2":
                return "jabtwo";
            case "Jab 3":
                return "jabthree";
            case "Rapid Jab":
                return "rapid";
            case "Grab":
                return "grab";
            case "Dash Grab":
                return "dgrab";
            case "Dash Attack":
                return "dash";
            case "Up Tilt":
                return "utilt";
            case "Down Tilt":
                return "dtilt";
            case "Forward Tilt":
                return "ftilt";
            case "Forward Tilt (Up)":
                return "ftiltup";
            case "Forward Tilt (Down)":
                return "ftiltdown";
            case "Forward Smash":
                return "fsmash";
            case "Up Smash":
                return "usmash";
            case "Down Smash":
                return "dsmash";
            case "Down-B":
                return "downb";
            case "Side-B":
                return "sideb";
            case "Up-B":
                return "upb";
            case "Neutral B":
                return "neutb";
            case "Spot-Dodge":
                return "spot";
            case "Air Dodge":
                return "airdodge";
            case "Forward Roll":
                return "rollfor";
            case "Back Roll":
                return "rollback";
            default:
                return getMarthSideB(move);
        }
    }

    public static String getMarthSideB(String move) {
        switch(move) {
            case "Side-B 1":
                return "sb1";
            case "Side-B 2 Side/Down":
                return "sb2s";
            case "Side-B 2 Up":
                return "sb2u";
            case "Side-B 3 Side":
                return "sb3s";
            case "Side-B 3 Up":
                return "sb3u";
            case "Side-B 3 Down":
                return "sb3d";
            case "Side-B 4 Side":
                return "sb4s";
            case "Side-B 4 Up":
                return "sb4u";
            case "Side-B 4 Down":
                return "sb4d";
            default:
                return "";
        }
    }

    public static String getLandLag(String character, String move) {
        switch(character) {
            case "Captain Falcon":
                return getFalconLandLag(move);
            case "Falco":
                return getFalcoLandLag(move);
            case "Fox":
                return getFalcoLandLag(move);
            case "Marth":
                return getMarthLandLag(move);
            case "Sheik":
                return getSheikLandLag(move);
            case "Ice Climbers":
                return getClimbersLandLag(move);
            case "Jigglypuff":
                return getJiggsLandLag(move);
            case "Samus Aran":
                return getSamusLandLag(move);
            case "Ganondorf":
                return getGanonLandLag(move);
            case "Pikachu":
                return getPikaLandLag(move);
            case "Yoshi":
                return getYoshiLandLag(move);
            case "Dr. Mario":
                return getDoctorLandLag(move);
            default:
                return "";
        }
    }

    public static String getIASA(String character, String move) {
        switch(character) {
            case "Captain Falcon":
                return getFalconIASA(move);
            case "Falco":
                return getFalcoIASA(move);
            case "Fox":
                return getFalcoIASA(move);
            case "Marth":
                return getMarthIASA(move);
            case "Sheik":
                return getSheikIASA(move);
            case "Ice Climbers":
                return getClimbersIASA(move);
            case "Jigglypuff":
                return getJiggsIASA(move);
            case "Samus Aran":
                return getSamusIASA(move);
            case "Ganondorf":
                return getGanonIASA(move);
            case "Pikachu":
                return getPikaIASA(move);
            case "Yoshi":
                return getYoshiIASA(move);
            case "Dr. Mario":
                return getDoctorIASA(move);
            default:
                return "";
        }
    }

    private static String getFalconIASA(String move) {
        switch(move) {
            case "fair":
                return "IASA: 36";
            case "bair":
                return "IASA: 29";
            case "uair":
                return "IASA: 30";
            case "dair":
                return "IASA: 38";
            case "jabthree":
                return "IASA: 23";
            case "dash":
                return "IASA: 38";
            case "utilt":
                return "IASA: 38";
            case "dtilt":
                return "IASA: 35";
            case "fsmash":
                return "IASA: 60";
            case "usmash":
                return "IASA: 40";
            case "dsmash":
                return "IASA: 49";
            default:
                return "  ";
        }
    }

    private static String getFalconLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 24";
            case "fair":
                return "Landing lag: 19";
            case "nair":
                return "Landing lag: 15";
            case "uair":
                return "Landing lag: 15";
            case "bair":
                return "Landing lag: 18";
            default:
                return "";
        }
    }

    private static String getFalcoLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 18";
            case "fair":
                return "Landing lag: 22";
            case "nair":
                return "Landing lag: 15";
            case "uair":
                return "Landing lag: 18";
            case "bair":
                return "Landing lag: 20";
            case "upb":
                return "Landing lag: 6";
            case "sideb":
                return "Landing lag: 20";
            case "downb":
                return "Landing lag: 45";
            default:
                return "";
        }
    }

    private static String getFalcoIASA(String move) {
        switch(move) {
            case "fair":
                return "IASA: 53";
            case "bair":
                return "IASA: 38";
            case "uair":
                return "IASA: 36";
            case "nair":
                return "IASA: 42";
            case "jabone":
                return "IASA: 16";
            case "jabtwo":
                return "IASA: 19";
            case "dash":
                return "IASA: 36";
            case "utilt":
                return "IASA: 23";
            case "dtilt":
                return "IASA: 28";
            case "dsmash":
                return "IASA: 46";
            default:
                return "  ";
        }
    }

    private static String getMarthLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 32";
            case "fair":
                return "Landing lag: 15";
            case "nair":
                return "Landing lag: 15";
            case "uair":
                return "Landing lag: 15";
            case "bair":
                return "Landing lag: 24";
            case "upb":
                return "Landing lag: 34";
            default:
                return "";
        }
    }

    private static String getMarthIASA(String move) {
        switch(move) {
            case "fair":
                return "IASA: 30";
            case "bair":
                return "IASA: 35";
            case "jabone":
                return "IASA: 26";
            case "jabtwo":
                return "IASA: 27";
            case "dash":
                return "IASA: 40";
            case "utilt":
                return "IASA: 32";
            case "dtilt":
                return "IASA: 20";
            case "fsmash":
                return "IASA: 48";
            case "usmash":
                return "IASA: 46";
            case "dsmash":
                return "IASA: 62";
            default:
                return "  ";
        }
    }

    private static String getSheikLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 20";
            case "fair":
                return "Landing lag: 16";
            case "nair":
                return "Landing lag: 16";
            case "uair":
                return "Landing lag: 24";
            case "bair":
                return "Landing lag: 16";
            case "upb":
                return "Landing lag: 30";
            default:
                return "";
        }
    }

    private static String getSheikIASA(String move) {
        switch(move) {
            case "nair":
                return "IASA: 42";
            case "uair":
                return "IASA: 37";
            case "jabone":
                return "IASA: 16";
            case "jabtwo":
                return "IASA: 17";
            case "dash":
                return "IASA: 36";
            case "utilt":
                return "IASA: 26";
            case "dtilt":
                return "IASA: 29";
            case "ftilt":
                return "IASA: 27";
            case "fsmash":
                return "IASA: 46";
            case "usmash":
                return "IASA: 46";
            case "dsmash":
                return "IASA: 46";
            default:
                return "  ";
        }
    }

    private static String getClimbersLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 25";
            case "fair":
                return "Landing lag: 20";
            case "nair":
                return "Landing lag: 20";
            case "uair":
                return "Landing lag: 32";
            case "bair":
                return "Landing lag: 20";
            case "upb":
                return "Landing lag: 25";
            case "sideb":
                return "Landing lag: 4";
            default:
                return "";
        }
    }

    private static String getClimbersIASA(String move) {
        switch(move) {
            case "nair":
                return "IASA: 20";
            case "uair":
                return "IASA: 32";
            case "bair":
                return "IASA: 36";
            case "dair":
                return "IASA: 55";
            case "jabone":
                return "IASA: 16";
            case "jabtwo":
                return "IASA: 18";
            case "dash":
                return "IASA: 38";
            case "utilt":
                return "IASA: 42";
            case "dtilt":
                return "IASA: 29";
            case "ftilt":
                return "IASA: 28";
            case "ftiltup":
                return "IASA: 28";
            case "ftiltdown":
                return "IASA: 28";
            case "fsmash":
                return "IASA: 47";
            case "usmash":
                return "IASA: 44";
            case "dsmash":
                return "IASA: 36";
            default:
                return "  ";
        }
    }

    private static String getJiggsLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 30";
            case "fair":
                return "Landing lag: 20";
            case "nair":
                return "Landing lag: 20";
            case "uair":
                return "Landing lag: 20";
            case "bair":
                return "Landing lag: 20";
            default:
                return "";
        }
    }

    private static String getJiggsIASA(String move) {
        switch(move) {
            case "uair":
                return "IASA: 38";
            case "bair":
                return "IASA: 31";
            case "fair":
                return "IASA: 35";
            case "jabone":
                return "IASA: 16";
            case "jabtwo":
                return "IASA: 17";
            case "dash":
                return "IASA: 39";
            case "dtilt":
                return "IASA: 30";
            case "usmash":
                return "IASA: 45";
            case "dsmash":
                return "IASA: 48";
            default:
                return "  ";
        }
    }

    private static String getSamusLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 15";
            case "fair":
                return "Landing lag: 15";
            case "nair":
                return "Landing lag: 15";
            case "uair":
                return "Landing lag: 15";
            case "bair":
                return "Landing lag: 15";
            case "upb":
                return "Landing lag: 24";
            default:
                return "";
        }
    }

    private static String getSamusIASA(String move) {
        switch(move) {
            case "uair":
                return "IASA: 39";
            case "bair":
                return "IASA: 37";
            case "fair":
                return "IASA: 50";
            case "dair":
                return "IASA: 49";
            case "nair":
                return "IASA: 40";
            case "utilt":
                return "IASA: 35";
            case "ftilt":
                return "IASA: 30";
            case "ftiltup":
                return "IASA: 30";
            case "ftiltdown":
                return "IASA: 30";
            case "usmash":
                return "IASA: 58";
            case "dsmash":
                return "IASA: 45";
            default:
                return "  ";
        }
    }

    private static String getGanonLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 38";
            case "fair":
                return "Landing lag: 25";
            case "nair":
                return "Landing lag: 25";
            case "uair":
                return "Landing lag: 30";
            case "bair":
                return "Landing lag: 25";
            case "upb":
                return "Landing lag: 30";
            case "sideb":
                return "Landing lag: 20";
            case "downb":
                return "Landing lag: 57";
            default:
                return "";
        }
    }

    private static String getGanonIASA(String move) {
        switch(move) {
            case "jabone":
                return "IASA: 19";
            case "uair":
                return "IASA: 30";
            case "bair":
                return "IASA: 29";
            case "fair":
                return "IASA: 35";
            case "dair":
                return "IASA: 38";
            case "utilt":
                return "IASA: 113";
            case "usmash":
                return "IASA: 40";
            case "dsmash":
                return "IASA: 47";
            case "fsmash":
                return "IASA: 60";
            case "dash":
                return "IASA: 38";
            default:
                return "  ";
        }
    }

    private static String getPikaLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 40";
            case "fair":
                return "Landing lag: 20";
            case "nair":
                return "Landing lag: 15";
            case "uair":
                return "Landing lag: 26";
            case "bair":
                return "Landing lag: 30";
            case "upb":
                return "Landing lag: 24";
            default:
                return "";
        }
    }

    private static String getPikaIASA(String move) {
        switch(move) {
            case "dair":
                return "IASA: 30";
            case "dtilt":
                return "IASA: 19";
            case "usmash":
                return "IASA: 41";
            case "dsmash":
                return "IASA: 51";
            default:
                return "  ";
        }
    }

    private static String getYoshiLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 26";
            case "fair":
                return "Landing lag: 21";
            case "nair":
                return "Landing lag: 15";
            case "uair":
                return "Landing lag: 19";
            case "bair":
                return "Landing lag: 15";
            default:
                return "";
        }
    }

    private static String getYoshiIASA(String move) {
        switch(move) {
            case "uair":
                return "IASA: 39";
            case "bair":
                return "IASA: 38";
            case "fair":
                return "IASA: 35";
            case "dair":
                return "IASA: 53";
            case "nair":
                return "IASA: 45";
            case "dash":
                return "IASA: 42";
            default:
                return "  ";
        }
    }

    private static String getDoctorLandLag(String move) {
        switch(move) {
            case "dair":
                return "Landing lag: 24";
            case "fair":
                return "Landing lag: 25";
            case "nair":
                return "Landing lag: 18";
            case "uair":
                return "Landing lag: 18";
            case "bair":
                return "Landing lag: 18";
            case "upb":
                return "Landing lag: 30";
            default:
                return "";
        }
    }

    private static String getDoctorIASA(String move) {
        switch(move) {
            case "dair":
                return "IASA: 38";
            case "fair":
                return "IASA: 60";
            case "utilt":
                return "IASA: 30";
            case "dash":
                return "IASA: 38";
            default:
                return "  ";
        }
    }
}
