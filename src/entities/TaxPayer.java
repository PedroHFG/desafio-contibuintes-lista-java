package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {

		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}


	public Double getSalaryIncome() {
		return salaryIncome;
	}


	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}


	public Double getServicesIncome() {
		return servicesIncome;
	}


	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}


	public Double getCapitalIncome() {
		return capitalIncome;
	}


	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}


	public Double getHealthSpending() {
		return healthSpending;
	}


	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}


	public Double getEducationSpending() {
		return educationSpending;
	}


	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double salaryPerMonth = salaryIncome / 12;
		
		if (salaryPerMonth < 3000) {
			return 0.00;
		}
		else if (salaryPerMonth < 5000) {
			return salaryPerMonth * 0.10 * 12;
		}
		else {
			return salaryPerMonth * 0.20 * 12;
		}
	}
	
	public double servicesTax() {
		return (servicesIncome > 0) ? servicesIncome * 0.15 : 0.00;
	}
	
	public double capitalTax() {
		return (capitalIncome > 0) ? capitalIncome * 0.20 : 0.00;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax(); 
	}
	
	public double taxRebate() {
		double maxRebate = grossTax() * 0.30;
		double totalSpent = healthSpending + educationSpending;
		double rebate;
		
		if (totalSpent < maxRebate) {
			rebate = totalSpent;
		}
		else {
			rebate = maxRebate;
		}
		
		return grossTax() - rebate;	
	}
	
	public String toString() {
		return
				"Imposto bruto total: " + String.format("%.2f%n", grossTax())
				+ "Abatimento: " + String.format("%.2f%n", grossTax() - taxRebate())
				+ "Imposto devido: " + String.format("%.2f", taxRebate());
	}
	
	
	
	
	
	
}
