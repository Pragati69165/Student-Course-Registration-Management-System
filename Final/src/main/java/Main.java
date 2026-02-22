import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;

public class Main {
    private static List<User> users = new ArrayList<>();
    public static void main(String[] args) {
        port(3000);

        // Homepage – navy hero on cream background
        get("/", (req, res) -> {
            return layout("Home",
                "<div class=\"hero-section text-center py-5\" style=\"background: #003049;\">\n" +
                "    <div class=\"container py-5\">\n" +
                "        <h1 class=\"display-4 fw-bold text-white\">Welcome to <span style=\"color: #669bbc;\">Engineering Course Registration</span></h1>\n" +
                "        <p class=\"lead text-white mb-4\">Your gateway to PCM‑based engineering admissions – register, check eligibility, and explore courses.</p>\n" +
                "        <div class=\"d-flex justify-content-center gap-3 flex-wrap\">\n" +
                "            <a href=\"/register\" class=\"btn btn-light btn-lg px-4 py-3 rounded-pill shadow-sm\" style=\"background: #669bbc; color: white; border: none;\"><i class=\"bi bi-person-plus-fill me-2\"></i>Register</a>\n" +
                "            <a href=\"/login\" class=\"btn btn-outline-light btn-lg px-4 py-3 rounded-pill\" style=\"border-color: #669bbc; color: #669bbc;\"><i class=\"bi bi-box-arrow-in-right me-2\"></i>Login</a>\n" +
                "            <a href=\"/calculator\" class=\"btn btn-light btn-lg px-4 py-3 rounded-pill shadow-sm\" style=\"background: #669bbc; color: white; border: none;\"><i class=\"bi bi-calculator-fill me-2\"></i>PCM Calculator</a>\n" +
                "            <a href=\"/courses\" class=\"btn btn-light btn-lg px-4 py-3 rounded-pill shadow-sm\" style=\"background: #669bbc; color: white; border: none;\"><i class=\"bi bi-book-fill me-2\"></i>Courses</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"container mt-5\">\n" +
                "    <div class=\"row g-4\">\n" +
                "        <div class=\"col-md-4\">\n" +
                "            <div class=\"card h-100 border-0 shadow-sm hover-card\" style=\"border-radius: 20px; background: white;\">\n" +
                "                <div class=\"card-body text-center p-4\">\n" +
                "                    <i class=\"bi bi-person-check-fill display-1\" style=\"color: #669bbc;\"></i>\n" +
                "                    <h5 class=\"card-title mt-3\" style=\"color: #003049;\">Easy Registration</h5>\n" +
                "                    <p class=\"card-text text-muted\">Quick sign‑up with name, email, and caste.</p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-4\">\n" +
                "            <div class=\"card h-100 border-0 shadow-sm hover-card\" style=\"border-radius: 20px; background: white;\">\n" +
                "                <div class=\"card-body text-center p-4\">\n" +
                "                    <i class=\"bi bi-graph-up-arrow display-1\" style=\"color: #669bbc;\"></i>\n" +
                "                    <h5 class=\"card-title mt-3\" style=\"color: #003049;\">PCM Eligibility</h5>\n" +
                "                    <p class=\"card-text text-muted\">Enter your marks and caste to know if you're eligible.</p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-4\">\n" +
                "            <div class=\"card h-100 border-0 shadow-sm hover-card\" style=\"border-radius: 20px; background: white;\">\n" +
                "                <div class=\"card-body text-center p-4\">\n" +
                "                    <i class=\"bi bi-journal-bookmark-fill display-1\" style=\"color: #669bbc;\"></i>\n" +
                "                    <h5 class=\"card-title mt-3\" style=\"color: #003049;\">20+ Engineering Courses</h5>\n" +
                "                    <p class=\"card-text text-muted\">Explore the full curriculum of core subjects.</p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            );
        });

        // Registration page – white card with navy & blue accents
        get("/register", (req, res) -> {
            return layout("Register",
                "<div class=\"row justify-content-center\">\n" +
                "    <div class=\"col-md-6\">\n" +
                "        <div class=\"card border-0 shadow-lg\" style=\"border-radius: 30px; background: white;\">\n" +
                "            <div class=\"card-header bg-transparent border-0 pt-4 text-center\">\n" +
                "                <i class=\"bi bi-person-plus-fill display-3\" style=\"color: #669bbc;\"></i>\n" +
                "                <h3 class=\"mt-2\" style=\"color: #003049;\">Create Account</h3>\n" +
                "            </div>\n" +
                "            <div class=\"card-body px-4 pb-4\">\n" +
                "                <form method=\"post\" action=\"/register\">\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-person me-2\" style=\"color: #669bbc;\"></i>Full Name</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-lg rounded-pill\" name=\"name\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-envelope me-2\" style=\"color: #669bbc;\"></i>Email address</label>\n" +
                "                        <input type=\"email\" class=\"form-control form-control-lg rounded-pill\" name=\"email\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-lock me-2\" style=\"color: #669bbc;\"></i>Password</label>\n" +
                "                        <input type=\"password\" class=\"form-control form-control-lg rounded-pill\" name=\"password\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-4\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-people me-2\" style=\"color: #669bbc;\"></i>Caste</label>\n" +
                "                        <select class=\"form-select form-select-lg rounded-pill\" name=\"caste\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                            <option value=\"General\">General</option>\n" +
                "                            <option value=\"OBC\">OBC</option>\n" +
                "                            <option value=\"SC\">SC</option>\n" +
                "                            <option value=\"ST\">ST</option>\n" +
                "                        </select>\n" +
                "                    </div>\n" +
                "                    <button type=\"submit\" class=\"btn btn-lg w-100 rounded-pill text-white\" style=\"background: #669bbc;\"><i class=\"bi bi-check2-circle me-2\"></i>Register</button>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            );
        });

        post("/register", (req, res) -> {
            String name = req.queryParams("name");
            String email = req.queryParams("email");
            String password = req.queryParams("password");
            String caste = req.queryParams("caste");

            if (name == null || email == null || password == null || caste == null ||
                name.isEmpty() || email.isEmpty() || password.isEmpty() || caste.isEmpty()) {
                return layout("Error",
                    "<div class=\"alert text-center\" style=\"background: white; color: #003049; border: 2px solid #669bbc; border-radius: 20px;\">\n" +
                    "    <i class=\"bi bi-exclamation-triangle-fill fs-1\" style=\"color: #669bbc;\"></i>\n" +
                    "    <h4 class=\"alert-heading\">All fields are required!</h4>\n" +
                    "    <hr>\n" +
                    "    <a href=\"/register\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\">Go back</a>\n" +
                    "</div>"
                );
            }

            users.add(new User(name, email, password, caste));

            return layout("Success",
                "<div class=\"alert text-center\" style=\"background: white; color: #003049; border: 2px solid #669bbc; border-radius: 20px;\">\n" +
                "    <i class=\"bi bi-check-circle-fill fs-1\" style=\"color: #669bbc;\"></i>\n" +
                "    <h4 class=\"alert-heading\">Registration successful!</h4>\n" +
                "    <p><strong>Name:</strong> " + name + "<br><strong>Email:</strong> " + email + "<br><strong>Caste:</strong> " + caste + "</p>\n" +
                "    <hr>\n" +
                "    <a href=\"/\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\">Go to Home</a>\n" +
                "</div>"
            );
        });

        // Login page – white card, navy & blue accents
        get("/login", (req, res) -> {
            return layout("Login",
                "<div class=\"row justify-content-center\">\n" +
                "    <div class=\"col-md-6\">\n" +
                "        <div class=\"card border-0 shadow-lg\" style=\"border-radius: 30px; background: white;\">\n" +
                "            <div class=\"card-header bg-transparent border-0 pt-4 text-center\">\n" +
                "                <i class=\"bi bi-box-arrow-in-right display-3\" style=\"color: #669bbc;\"></i>\n" +
                "                <h3 class=\"mt-2\" style=\"color: #003049;\">Welcome Back</h3>\n" +
                "            </div>\n" +
                "            <div class=\"card-body px-4 pb-4\">\n" +
                "                <form method=\"post\" action=\"/login\">\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-envelope me-2\" style=\"color: #669bbc;\"></i>Email address</label>\n" +
                "                        <input type=\"email\" class=\"form-control form-control-lg rounded-pill\" name=\"email\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-4\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-lock me-2\" style=\"color: #669bbc;\"></i>Password</label>\n" +
                "                        <input type=\"password\" class=\"form-control form-control-lg rounded-pill\" name=\"password\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <button type=\"submit\" class=\"btn btn-lg w-100 rounded-pill text-white\" style=\"background: #669bbc;\"><i class=\"bi bi-check2-circle me-2\"></i>Login</button>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            );
        });

        post("/login", (req, res) -> {
            String email = req.queryParams("email");
            String password = req.queryParams("password");

            boolean found = users.stream().anyMatch(u -> u.email.equals(email) && u.password.equals(password));

            if (found) {
                return layout("Login Successful",
                    "<div class=\"alert text-center\" style=\"background: white; color: #003049; border: 2px solid #669bbc; border-radius: 20px;\">\n" +
                    "    <i class=\"bi bi-emoji-smile-fill fs-1\" style=\"color: #669bbc;\"></i>\n" +
                    "    <h4 class=\"alert-heading\">Welcome back, " + email + "!</h4>\n" +
                    "    <p>You have successfully logged in.</p>\n" +
                    "    <hr>\n" +
                    "    <a href=\"/\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\">Go to Home</a>\n" +
                    "</div>"
                );
            } else {
                return layout("Login Failed",
                    "<div class=\"alert text-center\" style=\"background: white; color: #003049; border: 2px solid #669bbc; border-radius: 20px;\">\n" +
                    "    <i class=\"bi bi-exclamation-octagon-fill fs-1\" style=\"color: #669bbc;\"></i>\n" +
                    "    <h4 class=\"alert-heading\">Invalid email or password</h4>\n" +
                    "    <hr>\n" +
                    "    <a href=\"/login\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\">Try again</a>\n" +
                    "</div>"
                );
            }
        });

        // PCM Calculator page
        get("/calculator", (req, res) -> {
            return layout("PCM Calculator",
                "<div class=\"row justify-content-center\">\n" +
                "    <div class=\"col-md-6\">\n" +
                "        <div class=\"card border-0 shadow-lg\" style=\"border-radius: 30px; background: white;\">\n" +
                "            <div class=\"card-header bg-transparent border-0 pt-4 text-center\">\n" +
                "                <i class=\"bi bi-calculator-fill display-3\" style=\"color: #669bbc;\"></i>\n" +
                "                <h3 class=\"mt-2\" style=\"color: #003049;\">PCM Eligibility</h3>\n" +
                "            </div>\n" +
                "            <div class=\"card-body px-4 pb-4\">\n" +
                "                <form method=\"post\" action=\"/calculator\">\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-rulers me-2\" style=\"color: #669bbc;\"></i>Physics (0-100)</label>\n" +
                "                        <input type=\"number\" class=\"form-control form-control-lg rounded-pill\" name=\"physics\" step=\"0.01\" min=\"0\" max=\"100\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-flask me-2\" style=\"color: #669bbc;\"></i>Chemistry (0-100)</label>\n" +
                "                        <input type=\"number\" class=\"form-control form-control-lg rounded-pill\" name=\"chemistry\" step=\"0.01\" min=\"0\" max=\"100\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-3\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-calculator me-2\" style=\"color: #669bbc;\"></i>Mathematics (0-100)</label>\n" +
                "                        <input type=\"number\" class=\"form-control form-control-lg rounded-pill\" name=\"maths\" step=\"0.01\" min=\"0\" max=\"100\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                    </div>\n" +
                "                    <div class=\"mb-4\">\n" +
                "                        <label class=\"form-label\" style=\"color: #003049;\"><i class=\"bi bi-people me-2\" style=\"color: #669bbc;\"></i>Caste</label>\n" +
                "                        <select class=\"form-select form-select-lg rounded-pill\" name=\"caste\" required style=\"border: 2px solid #669bbc;\">\n" +
                "                            <option value=\"General\">General</option>\n" +
                "                            <option value=\"OBC\">OBC</option>\n" +
                "                            <option value=\"SC\">SC</option>\n" +
                "                            <option value=\"ST\">ST</option>\n" +
                "                        </select>\n" +
                "                    </div>\n" +
                "                    <button type=\"submit\" class=\"btn btn-lg w-100 rounded-pill text-white\" style=\"background: #669bbc;\"><i class=\"bi bi-check2-circle me-2\"></i>Check Eligibility</button>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            );
        });

        post("/calculator", (req, res) -> {
            try {
                double physics = Double.parseDouble(req.queryParams("physics"));
                double chemistry = Double.parseDouble(req.queryParams("chemistry"));
                double maths = Double.parseDouble(req.queryParams("maths"));
                String caste = req.queryParams("caste");

                if (physics < 0 || physics > 100 || chemistry < 0 || chemistry > 100 || maths < 0 || maths > 100) {
                    return layout("Error",
                        "<div class=\"alert text-center\" style=\"background: white; color: #003049; border: 2px solid #669bbc; border-radius: 20px;\">\n" +
                        "    <i class=\"bi bi-exclamation-triangle-fill fs-1\" style=\"color: #669bbc;\"></i>\n" +
                        "    <h4>Marks must be between 0 and 100.</h4>\n" +
                        "    <hr>\n" +
                        "    <a href=\"/calculator\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\">Go back</a>\n" +
                        "</div>"
                    );
                }

                double percentage = (physics + chemistry + maths) / 3.0;
                double minRequired = getMinPercentage(caste);
                boolean eligible = percentage >= minRequired;
                String resultText = eligible ? "Eligible" : "Not Eligible";

                // Style the badge according to eligibility
                String badgeStyle = eligible
                    ? "background: #669bbc; color: white;"
                    : "background: white; color: #669bbc; border: 2px solid #669bbc;";

                return layout("Eligibility Result",
                    "<div class=\"row justify-content-center\">\n" +
                    "    <div class=\"col-md-6\">\n" +
                    "        <div class=\"card shadow-lg border-0\" style=\"border-radius: 30px; background: white;\">\n" +
                    "            <div class=\"card-header text-white text-center py-3\" style=\"background: #003049; border-radius: 30px 30px 0 0;\">\n" +
                    "                <i class=\"bi bi-clipboard-check-fill display-4\"></i>\n" +
                    "                <h3 class=\"mb-0\">Result</h3>\n" +
                    "            </div>\n" +
                    "            <div class=\"card-body p-4\">\n" +
                    "                <ul class=\"list-group list-group-flush mb-3\">\n" +
                    "                    <li class=\"list-group-item d-flex justify-content-between align-items-center\">\n" +
                    "                        Physics <span class=\"badge rounded-pill p-2 text-white\" style=\"background: #669bbc;\">" + String.format("%.2f", physics) + "</span>\n" +
                    "                    </li>\n" +
                    "                    <li class=\"list-group-item d-flex justify-content-between align-items-center\">\n" +
                    "                        Chemistry <span class=\"badge rounded-pill p-2 text-white\" style=\"background: #669bbc;\">" + String.format("%.2f", chemistry) + "</span>\n" +
                    "                    </li>\n" +
                    "                    <li class=\"list-group-item d-flex justify-content-between align-items-center\">\n" +
                    "                        Mathematics <span class=\"badge rounded-pill p-2 text-white\" style=\"background: #669bbc;\">" + String.format("%.2f", maths) + "</span>\n" +
                    "                    </li>\n" +
                    "                    <li class=\"list-group-item d-flex justify-content-between align-items-center fw-bold\">\n" +
                    "                        Percentage <span class=\"badge rounded-pill p-2 text-white\" style=\"background: #669bbc;\">" + String.format("%.2f", percentage) + "%</span>\n" +
                    "                    </li>\n" +
                    "                    <li class=\"list-group-item d-flex justify-content-between align-items-center\">\n" +
                    "                        Min Required (" + caste + ") <span class=\"badge rounded-pill p-2 text-white\" style=\"background: #669bbc;\">" + String.format("%.1f", minRequired) + "%</span>\n" +
                    "                    </li>\n" +
                    "                </ul>\n" +
                    "                <div class=\"d-grid gap-2\">\n" +
                    "                    <span class=\"badge p-3 fs-4 rounded-pill\" style=\"" + badgeStyle + "\">" + resultText + "</span>\n" +
                    "                    <a href=\"/calculator\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\"><i class=\"bi bi-arrow-repeat me-2\"></i>Calculate again</a>\n" +
                    "                    <a href=\"/\" class=\"btn rounded-pill\" style=\"border: 2px solid #669bbc; color: #669bbc;\"><i class=\"bi bi-house me-2\"></i>Home</a>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>"
                );

            } catch (NumberFormatException e) {
                return layout("Error",
                    "<div class=\"alert text-center\" style=\"background: white; color: #003049; border: 2px solid #669bbc; border-radius: 20px;\">\n" +
                    "    <i class=\"bi bi-exclamation-triangle-fill fs-1\" style=\"color: #669bbc;\"></i>\n" +
                    "    <h4>Invalid input. Please enter numeric marks.</h4>\n" +
                    "    <hr>\n" +
                    "    <a href=\"/calculator\" class=\"btn rounded-pill text-white\" style=\"background: #669bbc;\">Try again</a>\n" +
                    "</div>"
                );
            }
        });

        // Engineering Courses page
        get("/courses", (req, res) -> {
            String[] courses = {
                "Engineering Mathematics - I", "Engineering Mathematics - II",
                "Engineering Physics", "Engineering Chemistry",
                "Programming in C", "Object Oriented Programming (Java)",
                "Data Structures", "Database Management System",
                "Operating Systems", "Computer Networks",
                "Digital Electronics", "Basic Electrical Engineering",
                "Engineering Mechanics", "Thermodynamics",
                "Fluid Mechanics", "Strength of Materials",
                "Software Engineering", "Web Development",
                "Environmental Studies", "Engineering Graphics & Design"
            };

            StringBuilder listItems = new StringBuilder();
            for (String course : courses) {
                listItems.append("<li class=\"list-group-item d-flex align-items-center\"><i class=\"bi bi-bookmark-check-fill me-3\" style=\"color: #669bbc;\"></i>").append(course).append("</li>\n");
            }

            return layout("Engineering Courses",
                "<div class=\"row justify-content-center\">\n" +
                "    <div class=\"col-md-8\">\n" +
                "        <div class=\"card shadow-lg border-0\" style=\"border-radius: 30px; background: white;\">\n" +
                "            <div class=\"card-header text-white text-center py-3\" style=\"background: #003049; border-radius: 30px 30px 0 0;\">\n" +
                "                <i class=\"bi bi-journals display-4\"></i>\n" +
                "                <h3 class=\"mb-0\">20 Engineering Courses</h3>\n" +
                "            </div>\n" +
                "            <div class=\"card-body p-4\">\n" +
                "                <ol class=\"list-group list-group-numbered\">\n" +
                "                    " + listItems.toString() +
                "                </ol>\n" +
                "                <div class=\"mt-4 text-center\">\n" +
                "                    <a href=\"/\" class=\"btn rounded-pill\" style=\"border: 2px solid #669bbc; color: #669bbc;\"><i class=\"bi bi-arrow-left me-2\"></i>Back to Home</a>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>"
            );
        });
    }

    private static double getMinPercentage(String caste) {
        switch (caste) {
            case "General": return 60.0;
            case "OBC": return 55.0;
            case "SC": return 50.0;
            case "ST": return 45.0;
            default: return 60.0;
        }
    }

    private static String layout(String title, String content) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>" + title + " | Engineering Registration</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css\">\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background: #fdf0d5;\n" +
                "            font-family: 'Inter', system-ui, -apple-system, 'Segoe UI', Roboto, sans-serif;\n" +
                "        }\n" +
                "        .navbar {\n" +
                "            background: #003049 !important;\n" +
                "            box-shadow: 0 2px 10px rgba(0,0,0,0.1);\n" +
                "        }\n" +
                "        .navbar-brand, .nav-link {\n" +
                "            color: white !important;\n" +
                "            font-weight: 500;\n" +
                "        }\n" +
                "        .nav-link:hover {\n" +
                "            color: #669bbc !important;\n" +
                "        }\n" +
                "        .hero-section {\n" +
                "            border-radius: 0 0 50px 50px;\n" +
                "        }\n" +
                "        .hover-card {\n" +
                "            transition: transform 0.3s ease, box-shadow 0.3s ease;\n" +
                "            border-radius: 20px;\n" +
                "            background: white;\n" +
                "        }\n" +
                "        .hover-card:hover {\n" +
                "            transform: translateY(-10px);\n" +
                "            box-shadow: 0 20px 40px rgba(102,155,188,0.2) !important;\n" +
                "        }\n" +
                "        .btn-light {\n" +
                "            background: #669bbc;\n" +
                "            color: white;\n" +
                "            border: none;\n" +
                "        }\n" +
                "        .btn-light:hover {\n" +
                "            background: #5288a8;\n" +
                "        }\n" +
                "        .btn-outline-light {\n" +
                "            border-color: white;\n" +
                "            color: white;\n" +
                "        }\n" +
                "        .btn-outline-light:hover {\n" +
                "            background: white;\n" +
                "            color: #003049;\n" +
                "        }\n" +
                "        footer {\n" +
                "            background: #003049;\n" +
                "            color: white;\n" +
                "            border-top: 1px solid #669bbc;\n" +
                "        }\n" +
                "        .card {\n" +
                "            background: white;\n" +
                "        }\n" +
                "        .form-control, .form-select {\n" +
                "            border: 2px solid #669bbc;\n" +
                "        }\n" +
                "        .form-control:focus, .form-select:focus {\n" +
                "            border-color: #003049;\n" +
                "            box-shadow: 0 0 0 0.2rem rgba(102,155,188,0.25);\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-dark\">\n" +
                "        <div class=\"container\">\n" +
                "            <a class=\"navbar-brand\" href=\"/\"><i class=\"bi bi-mortarboard-fill me-2\"></i>Engineering Course Registration</a>\n" +
                "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\">\n" +
                "                <span class=\"navbar-toggler-icon\"></span>\n" +
                "            </button>\n" +
                "            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" +
                "                <ul class=\"navbar-nav ms-auto\">\n" +
                "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/\"><i class=\"bi bi-house me-1\"></i>Home</a></li>\n" +
                "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/register\"><i class=\"bi bi-person-plus me-1\"></i>Register</a></li>\n" +
                "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/login\"><i class=\"bi bi-box-arrow-in-right me-1\"></i>Login</a></li>\n" +
                "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/calculator\"><i class=\"bi bi-calculator me-1\"></i>Calculator</a></li>\n" +
                "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/courses\"><i class=\"bi bi-book me-1\"></i>Courses</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "\n" +
                "    <main class=\"container my-5\">\n" +
                "        " + content + "\n" +
                "    </main>\n" +
                "\n" +
                "    <footer class=\"text-center py-4\">\n" +
                "        <div class=\"container\">\n" +
                "            <p class=\"mb-0\">© 2026 Engineering Registration System - Designed by Pragati Prajapati</p>\n" +
                "        </div>\n" +
                "    </footer>\n" +
                "\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";
    }

    static class User {
        String name;
        String email;
        String password;
        String caste;

        User(String name, String email, String password, String caste) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.caste = caste;
        }
    }
}