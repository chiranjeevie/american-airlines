# Define variables
variable "app_service_name" {
  description = "Name of the Azure App Service"
  type        = string
}

variable "runtime" {
  description = "Runtime for the App Service (e.g., JAVA|11 or DOTNETCORE|3.1)"
  type        = string
}

# Azure provider
provider "azurerm" {
  features {}
}

# Create a resource group
resource "azurerm_resource_group" "american_airlines" {
  name     = "american-airlines-resources"
  location = "East US"
}

# Create an App Service Plan
resource "azurerm_app_service_plan" "american_airlines" {
  name                = "american-airlines-appserviceplan"
  location            = azurerm_resource_group.american_airlines.location
  resource_group_name = azurerm_resource_group.american_airlines.name
  kind                = "Linux"
  reserved            = true

  sku {
    tier = "Basic"
    size = "B1"
  }
}

# Create an App Service
resource "azurerm_app_service" "american_airlines" {
  name                = var.app_service_name
  location            = azurerm_resource_group.american_airlines.location
  resource_group_name = azurerm_resource_group.american_airlines.name
  app_service_plan_id = azurerm_app_service_plan.american_airlines.id

  site_config {
    # Use conditional logic based on the specified runtime
    linux_fx_version = var.runtime == "JAVA|11" ? "JAVA|11" : "DOTNETCORE|3.1"
  }
}

# Output the resource group name
output "resource_group_name" {
  value = azurerm_resource_group.american_airlines.name
}
