/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.28
 * Generated at: 2024-09-02 07:51:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.Random;
import com.revature.ecom.DAO.categoryDAO;
import com.revature.ecom.Models.adminModel;
import com.revature.ecom.Models.cartModel;
import com.revature.ecom.DAO.cartDAO;
import com.revature.ecom.Models.userModel;
import java.util.List;
import com.revature.ecom.Models.categoryModel;
import com.revature.ecom.Utils.DatabaseUtil;
import com.revature.ecom.DAO.categoryDAO;
import com.revature.ecom.Models.messageModel;

public final class forgot_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/Components/alert_message.jsp", Long.valueOf(1724990341171L));
    _jspx_dependants.put("/Components/navbar.jsp", Long.valueOf(1725132993796L));
    _jspx_dependants.put("/Components/common_css_js.jsp", Long.valueOf(1725114981486L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(14);
    _jspx_imports_classes.add("com.revature.ecom.Models.adminModel");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.revature.ecom.DAO.categoryDAO");
    _jspx_imports_classes.add("com.revature.ecom.DAO.cartDAO");
    _jspx_imports_classes.add("com.revature.ecom.Models.userModel");
    _jspx_imports_classes.add("com.revature.ecom.Models.cartModel");
    _jspx_imports_classes.add("java.util.Random");
    _jspx_imports_classes.add("com.revature.ecom.Utils.DatabaseUtil");
    _jspx_imports_classes.add("com.revature.ecom.Models.messageModel");
    _jspx_imports_classes.add("com.revature.ecom.Models.categoryModel");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>Forget Password</title>\n");
      out.write("<!--CSS-->\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\n");
      out.write("<!--font awesome-->\n");
      out.write("<!--<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("-->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"CSS/style.css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--JavaScript-->\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"JS/script.js\"></script>\n");
      out.write("\n");
      out.write("<!--jQuery-->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\n");
      out.write("<!--sweet alert-->\n");
      out.write("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("label {\n");
      out.write("	font-weight: bold;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<!--navbar -->\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

userModel user = (userModel) session.getAttribute("activeUser");
adminModel admin = (adminModel) session.getAttribute("activeAdmin");

categoryDAO catDao = new categoryDAO(DatabaseUtil.getConnection());
List<categoryModel> categoryList = catDao.getAllCategories();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("/* General navbar styling */\r\n");
      out.write(".navbar {\r\n");
      out.write("    background-color: #34495e;\r\n");
      out.write("    padding: 1rem;\r\n");
      out.write("    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);\r\n");
      out.write("    max-height:15vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-brand {\r\n");
      out.write("    font-size: 1.6rem;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    color: #ecf0f1 !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".nav-link {\r\n");
      out.write("    color: #bdc3c7 !important;\r\n");
      out.write("    margin-right: 1rem;\r\n");
      out.write("    transition: color 0.3s, background-color 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".nav-link:hover {\r\n");
      out.write("    color: #ecf0f1 !important;\r\n");
      out.write("    background-color: rgba(255, 255, 255, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-toggler {\r\n");
      out.write("    border-color: #ecf0f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-toggler-icon {\r\n");
      out.write("    background-image: url(\"data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3E%3Cpath stroke='rgba%2899, 110, 114, 1%29' stroke-width='2' linecap='round' linejoin='round' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-menu {\r\n");
      out.write("    background-color: #2c3e50 !important;\r\n");
      out.write("    border: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-item {\r\n");
      out.write("    color: #bdc3c7 !important;\r\n");
      out.write("    transition: background-color 0.3s, color 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-item:hover {\r\n");
      out.write("    background-color: #34495e !important;\r\n");
      out.write("    color: #ecf0f1 !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".badge {\r\n");
      out.write("    font-size: 0.75rem;\r\n");
      out.write("    background-color: #e74c3c;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Button styling */\r\n");
      out.write(".btn-outline-light {\r\n");
      out.write("    color: #bdc3c7;\r\n");
      out.write("    border-color: #bdc3c7;\r\n");
      out.write("    transition: color 0.3s, border-color 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-outline-light:hover {\r\n");
      out.write("    color: #ecf0f1;\r\n");
      out.write("    border-color: #ecf0f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Flexbox alignment */\r\n");
      out.write(".navbar-nav {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-nav .nav-item {\r\n");
      out.write("    margin-right: 0rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-control {\r\n");
      out.write("    background-color: #2c3e50 !important;\r\n");
      out.write("    border: none;\r\n");
      out.write("    color: #ecf0f1;\r\n");
      out.write("    margin-right: 0.5rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-control::placeholder {\r\n");
      out.write("    color: #bdc3c7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-control:focus {\r\n");
      out.write("    box-shadow: none;\r\n");
      out.write("    border-color: #ecf0f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (max-width: 992px) {\r\n");
      out.write("    .navbar-collapse {\r\n");
      out.write("        flex-direction: column;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .navbar-nav {\r\n");
      out.write("        flex-direction: column;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-nav .nav-item {\r\n");
      out.write("        margin-right: 0;\r\n");
      out.write("        margin-bottom: 1rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .form-control {\r\n");
      out.write("        margin-bottom: 1rem;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Specific logo styles */\r\n");
      out.write(".navbar-nav .register-link {\r\n");
      out.write("    background-image: url('path/to/register-icon.png');\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-position: left center;\r\n");
      out.write("    padding-left: 30px; /* Adjust based on the size of the icon */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-nav .buyer-link {\r\n");
      out.write("    background-image: url('path/to/buyer-icon.png');\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-position: left center;\r\n");
      out.write("    padding-left: 30px; /* Adjust based on the size of the icon */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-nav .seller-link {\r\n");
      out.write("    background-image: url('path/to/seller-icon.png');\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-position: left center;\r\n");
      out.write("    padding-left: 30px; /* Adjust based on the size of the icon */\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"index.jsp\" style=\"font-weight: bold; font-size: 1.5rem; margin-right:7vh; background: linear-gradient(45deg, #000000, #ff4081, #007bff); -webkit-background-clip: text; -webkit-text-fill-color: transparent;\">\r\n");
      out.write("    <i class=\"fa-sharp fa-solid fa-house\"></i>&ensp;RevShop\r\n");
      out.write("</a>\r\n");
      out.write("\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\"\r\n");
      out.write("            aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("            ");
 if (admin != null) { 
      out.write("\r\n");
      out.write("            <!-- Admin nav bar -->\r\n");
      out.write("            <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-dark nav-link d-flex align-items-center rounded-pill px-3 py-2 shadow-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#add-category\">\r\n");
      out.write("            <i class=\"fa-solid fa-plus fa-xs me-2\"></i>Add Category\r\n");
      out.write("        </button>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary nav-link d-flex align-items-center rounded-pill px-3 py-2 shadow-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#add-product\">\r\n");
      out.write("            <i class=\"fa-solid fa-plus fa-xs me-2\"></i>Add Product\r\n");
      out.write("        </button>\r\n");
      out.write("    </li>\r\n");
      out.write("</ul>\r\n");
      out.write("<ul class=\"navbar-nav ms-auto\">\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link text-info fw-light d-flex align-items-center\" href=\"admin.jsp\">\r\n");
      out.write("            <i class=\"fa-solid fa-user-circle fa-lg me-2\"></i>");
      out.print(admin.getName());
      out.write("\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link text-danger fw-light d-flex align-items-center\" href=\"logout?user=admin\">\r\n");
      out.write("            <i class=\"fa-solid fa-sign-out-alt fa-lg me-2\"></i>Logout\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
 } else { 
      out.write("\r\n");
      out.write("            <!-- General nav bar -->\r\n");
      out.write("            <!-- Navigation items for products and category -->\r\n");
      out.write("<ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link text-dark rounded-pill px-3 py-2 shadow-sm d-flex align-items-center\" href=\"products.jsp\" role=\"button\" aria-expanded=\"false\">\r\n");
      out.write("            Products\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item dropdown\">\r\n");
      out.write("        <a class=\"nav-link dropdown-toggle text-dark rounded-pill px-3 py-2 shadow-sm d-flex align-items-center\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("            Category\r\n");
      out.write("        </a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("            <li><a class=\"dropdown-item\" href=\"products.jsp?category=0\">All Products</a></li>\r\n");
      out.write("            ");
 for (categoryModel c : categoryList) { 
      out.write("\r\n");
      out.write("            <li><a class=\"dropdown-item\" href=\"products.jsp?category=");
      out.print(c.getCategoryId());
      out.write('"');
      out.write('>');
      out.print(c.getCategoryName());
      out.write("</a></li>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("<!-- Search form -->\r\n");
      out.write("<form class=\"d-flex pe-5\" role=\"search\" action=\"products.jsp\" method=\"get\">\r\n");
      out.write("    <input name=\"search\" class=\"form-control me-2 rounded-pill border-0 shadow-sm\" size=\"50\" type=\"search\" placeholder=\"Search for products\" aria-label=\"Search\">\r\n");
      out.write("    <button class=\"btn btn-outline-dark rounded-pill px-4\" type=\"submit\">Search</button>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<!-- User actions for logged-in users -->\r\n");
 if (user != null) {
    cartDAO cartDao = new cartDAO(DatabaseUtil.getConnection());
    int cartCount = cartDao.getCartCountByUserId(user.getUserId());

      out.write("\r\n");
      out.write("<ul class=\"navbar-nav ms-auto\">\r\n");
      out.write("    <li class=\"nav-item pe-3\">\r\n");
      out.write("        <a class=\"nav-link position-relative d-flex align-items-center rounded-pill px-3 py-2 shadow-sm\" href=\"cart.jsp\">\r\n");
      out.write("            <i class=\"fa-solid fa-cart-shopping me-2\"></i> Cart\r\n");
      out.write("            <span class=\"position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger\">");
      out.print(cartCount);
      out.write("</span>\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item pe-3\">\r\n");
      out.write("        <a class=\"nav-link text-dark rounded-pill px-3 py-2 shadow-sm d-flex align-items-center\" href=\"profile.jsp\">\r\n");
      out.write("            <i class=\"fa-solid fa-user me-2\"></i>");
      out.print(user.getUserName());
      out.write("\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item pe-3\">\r\n");
      out.write("        <a class=\"nav-link text-danger rounded-pill px-3 py-2 shadow-sm d-flex align-items-center\" href=\"logout?user=user\">\r\n");
      out.write("            <i class=\"fa-solid fa-sign-out-alt me-2\"></i> Logout\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("</ul>\r\n");
 } else { 
      out.write("\r\n");
      out.write("<!-- User actions for guests -->\r\n");
      out.write("<ul class=\"navbar-nav ms-auto\">\r\n");
      out.write("    <li class=\"nav-item pe-2\">\r\n");
      out.write("        <a class=\"nav-link btn btn-outline-primary rounded-pill px-3 py-2\" href=\"login.jsp\">Login</a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item pe-2\">\r\n");
      out.write("        <a class=\"nav-link btn btn-outline-success rounded-pill px-3 py-2\" href=\"adminlogin.jsp\">Seller</a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"nav-item pe-3\">\r\n");
      out.write("        <a class=\"nav-link position-relative d-flex align-items-center rounded-pill px-3 py-2 shadow-sm\" href=\"cart.jsp\">\r\n");
      out.write("            <i class=\"fa-solid fa-cart-shopping me-2\"></i> Cart\r\n");
      out.write("            <span class=\"position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger\"></span>\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("</ul>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\n");
      out.write("\n");
      out.write("	<div class=\"container-fluid \">\n");
      out.write("		<div class=\"row mt-5\">\n");
      out.write("			<div class=\"col-md-4 offset-md-4\">\n");
      out.write("				<div class=\"card\">\n");
      out.write("					<div class=\"card-body px-5\">\n");
      out.write("\n");
      out.write("						<div class=\"container text-center\">\n");
      out.write("							<img src=\"Images/forgot-password.png\" style=\"max-width: 100px;\"\n");
      out.write("								class=\"img-fluid\">\n");
      out.write("						</div>\n");
      out.write("						<h3 class=\"text-center mt-3\">Change Password</h3>\n");
      out.write("						");
      out.write('\n');

messageModel messg = (messageModel) session.getAttribute("message");
if (messg != null) {

      out.write("\n");
      out.write("<div class=\"alert ");
      out.print(messg.getCssClass());
      out.write("\" role=\"alert\" id=\"alert\">\n");
      out.write("	");
      out.print(messg.getMessage());
      out.write("\n");
      out.write("</div>\n");

session.removeAttribute("message");
}

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("	setTimeout(function() {\n");
      out.write("		$('#alert').alert('close');\n");
      out.write("	}, 3000);\n");
      out.write("</script>");
      out.write("\n");
      out.write("\n");
      out.write("						<!--change password-->\n");
      out.write("						<form action=\"ChangePasswordServlet\" method=\"post\">\n");
      out.write("							<div class=\"mb-3\">\n");
      out.write("								<label class=\"form-label\">Email</label> <input type=\"email\"\n");
      out.write("									name=\"email\" placeholder=\"Enter email\" class=\"form-control\"\n");
      out.write("									required>\n");
      out.write("							</div>\n");
      out.write("							<div class=\"container text-center\">\n");
      out.write("								<button type=\"submit\" class=\"btn btn-outline-primary me-3\">Submit</button>\n");
      out.write("							</div>\n");
      out.write("						</form>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
