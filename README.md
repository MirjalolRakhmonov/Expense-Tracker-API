# Expense-Tracker-API
Using Spring Boot and Java to create a complete REST API. I am using PostgreSQL as the relational database and Spring JdbcTemplate for interacting with that.  Apart from this, I am adding authentication using JWT (JSON Web Tokens).

CRUD OPERATIONS
# USERS
@RequestMapping("/api/users")

* @PostMapping("/login")
* @PostMapping("/register")

# CATEGORIES
* @RequestMapping("/api/categories")

* @GetMapping("")
* @GetMapping("/{categoryId}")

* @PostMapping("")

* @PutMapping("/{categoryId}")

* @DeleteMapping("/{categoryId}")

# Transactions
* @RequestMapping("/api/categories/{categoryId}/transactions")

* @GetMapping("")
* @GetMapping("{transactionId}")

* @PostMapping("")

* @PutMapping("/{transactionId}")

* @DeleteMapping("/{transactionId}")
