public class Expense {
    private int id;
    private String category;
    private String description;
    private double amount;
    private String date;
   

    public Expense(String category, String description, double amount, String date) {                  // new
        this.category = category;
    	this.description = description;
        this.amount = amount;
        this.date = date;
    }


	


	public int getId() {
		return id;
	}


	public String getCategory() {
		return category;
	}


	public String getDescription() {
		return description;
	}


	public double getAmount() {
		return amount;
	}


	public String getDate() {
		return date;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public void setDate(String date) {
		this.date = date;
	}

	
    // Getters and setters
    
}

