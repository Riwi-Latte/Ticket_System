package view;

import javax.swing.JOptionPane;

import controller.categoryController;

public class categoryView {

    private categoryController categoryController;

    public categoryView(categoryController categoryController) {
        this.categoryController = categoryController;
    };
    
    public void categoryMenu(){

        String menu = """
                
            Menu Categorias

            1.Crear categoria.
            2.Eliminar categoria.
            3.Listar categorias.
            4.Salir

            Seleccionar una opcion:
                """;

        String input;

        do {
            input = JOptionPane.showInputDialog(null, menu, "Menu Categorias", JOptionPane.QUESTION_MESSAGE);

            switch (input) {
                case "1":
                    
                    break;

                case "2":
                    break;

                case "3":
                    break;    

                default:
                    showError("Opcion invalida. Intente nuevamente.");
            }
            
        } while (input != "4");


    }

    public void showError(String message) {
        //Show messege error
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);   
    }

    public void createCategory(){

        try {
            String nameCategory = JOptionPane.showInputDialog("Ingrese el nombre de la nueva categoria:");

            if (nameCategory == null || nameCategory.isEmpty()) {
                showError("Error al crear la categoria. Intente nuevamente.");
                return;
                
            }

            Boolean create = categoryController.createCategoryController(nameCategory.toUpperCase());

            if (create) {
                JOptionPane.showMessageDialog(null, "Categoria creada exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);   
            } else {
                showError("La categoria ya existe. Intente nuevamente.");
            }
            
        } catch (NumberFormatException e) {
            showError("Error al crear la categoria. Intente nuevamente.");
        }


        


    }


}
