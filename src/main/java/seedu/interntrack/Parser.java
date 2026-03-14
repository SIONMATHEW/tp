package seedu.interntrack;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Parses user input strings into Application objects.
 */
public class Parser {

    public static final String REGEX = "(?=c/|r/|ct/|d/)";
    private static final String DATE_FORMAT_ERROR = "Date must be in YYYY-MM-DD format.";
    private static final String STATUS_PREFIX = "s/";
    private static final String EDIT_FORMAT_ERROR = "Use format: edit INDEX s/NEW_STATUS";
    private static final Logger logger = Logger.getLogger("Parser");
    /**
     * Creates an Application from a raw user input string.
     *
     * @param input The full command string entered by the user.
     * @return The constructed Application object.
     * @throws InternTrackException If required fields are missing or the date format is invalid.
     */
    public static Application createApplication(String input) throws InternTrackException {
        String[] parts = input.split(REGEX);
        String company = null;
        String role = null;
        String contact = null;
        LocalDate deadline = null;
        for (String part : parts) {
            String trimmed = part.trim();
            if (trimmed.startsWith("c/")) {
                company = trimmed.substring(2).trim();
            } else if (trimmed.startsWith("r/")) {
                role = trimmed.substring(2).trim();
            } else if (trimmed.startsWith("ct/")) {
                contact = trimmed.substring(3).trim();
            } else if (trimmed.startsWith("d/")) {
                try {
                    deadline = LocalDate.parse(trimmed.substring(2).trim());
                } catch (Exception e) {
                    logger.log(Level.WARNING, "Invalid date format in input: " + trimmed);
                    throw new InternTrackException(DATE_FORMAT_ERROR);
                }
            }
        }
        if (company == null || role == null) {
            logger.log(Level.WARNING, "Missing required fields in add command");
            throw new InternTrackException("Both company (c/) and role (r/) are required!");
        }
        // Assertions to verify internal invariants after parsing
        assert company != null && !company.isEmpty() : "Company name should have been captured";
        assert role != null && !role.isEmpty() : "Role title should have been captured";
        logger.log(Level.INFO, "Successfully parsed application: company=" + company + ", role=" + role);
        return new Application(company, role, deadline, contact);
    }

    /**
     * Parses the application index from an edit command.
     *
     * @param input The raw user input string.
     * @return The parsed 1-based index.
     * @throws InternTrackException If the index is missing or invalid.
     */
    public static int parseEditIndex(String input) throws InternTrackException {
        String[] parts = input.trim().split("\\s+", 3);

        if (parts.length < 3) {
            throw new InternTrackException(EDIT_FORMAT_ERROR);
        }

        try {
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new InternTrackException("Application index must be a valid number.");
        }
    }

    /**
     * Parses the new status from an edit command.
     *
     * @param input The raw user input string.
     * @return The parsed status string.
     * @throws InternTrackException If the status is missing.
     */
    public static String parseEditStatus(String input) throws InternTrackException {
        String[] parts = input.trim().split("\\s+", 3);

        if (parts.length < 3 || !parts[2].startsWith(STATUS_PREFIX)) {
            throw new InternTrackException(EDIT_FORMAT_ERROR);
        }

        String status = parts[2].substring(STATUS_PREFIX.length()).trim();

        if (status.isEmpty()) {
            throw new InternTrackException("Status cannot be empty.");
        }

        return status;
    }
}
