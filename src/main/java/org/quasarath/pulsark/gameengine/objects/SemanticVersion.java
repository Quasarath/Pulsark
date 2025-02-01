package org.quasarath.pulsark.gameengine.objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticVersion {
    
    private int major;
    private int minor;
    private int bgfix;

    private int dev;

    private String con;

    private SemanticVersion(int major, int minor, int bugfix, int dev, char type) {
        this.major = major;
        this.minor = minor;
        this.bgfix = bugfix;
        this.dev = dev;
        this.con = switch (type) {
            case 'c' -> "-rc.";
            case 'a' -> "-alpha.";
            case 'b' -> "-beta.";
            case 'd' -> "-dev.";
            default -> ""; 
        };
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        if (this.con.equalsIgnoreCase("")) {
            out.append(this.major).append('.');
            out.append(this.minor).append('.');
            out.append(this.bgfix);
            return out.toString();
        }

        out.append(this.major).append('.');
        out.append(this.minor).append('.');
        out.append(this.bgfix).append(this.con);
        out.append(this.dev);
        return out.toString();
    }

    public static SemanticVersion fromString(String version) {
        Pattern pattern = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(?:-(alpha|beta|rc|dev)\\.(\\d+))?");
        Matcher matcher = pattern.matcher(version);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid semantic version format: " + version);
        }

        int major = Integer.parseInt(matcher.group(1));
        int minor = Integer.parseInt(matcher.group(2));
        int bugfix = Integer.parseInt(matcher.group(3));
        int dev = matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 0;

        char type = 'r';
        if (matcher.group(4) != null) {
            type = switch (matcher.group(4)) {
                case "alpha" -> 'a';
                case "beta" -> 'b';
                case "rc" -> 'c';
                case "dev" -> 'd';
                default -> 'r';
            };
        }
        return new SemanticVersion(major, minor, bugfix, dev, type);
    }

    public static SemanticVersion newAlpha(int major, int minor, int bugfix, int build) {
        return new SemanticVersion(major, minor, bugfix, build, 'a');
    }

    public static SemanticVersion newBeta(int major, int minor, int bugfix, int build) {
        return new SemanticVersion(major, minor, bugfix, build, 'b');
    }

    public static SemanticVersion newRelCandidate(int major, int minor, int bugfix, int build) {
        return new SemanticVersion(major, minor, bugfix, build, 'c');
    }

    public static SemanticVersion newRelease(int major, int minor, int bugfix) {
        return new SemanticVersion(major, minor, bugfix, 0, 'r');
    }

    public static SemanticVersion newDev(int major, int minor, int bugfix, int build) {
        return new SemanticVersion(major, minor, bugfix, build, 'd');
    }
}
