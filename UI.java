import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class UI extends javax.swing.JFrame {
    DefaultTableModel model;

    @Override
    public void layout() {
        super.layout(); 
    }


    public UI() {
        initComponents();



    }  public void populateTable(){

        model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Product> products =getProducts();
            for(Product product:products){
                Object[] row ={product.getProductID(),product.getProductName(),product.getStockAmount(),product.getProductCategory()};
                model.addRow(row);
            }
        } catch ( SQLException exception) {


        }
    }
    public ArrayList<Product> getProducts()throws SQLException{
        Connection connection = null;
        DBHelper dBHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Product> products = null;
        try {
            connection = dBHelper.getConnection();
            statement = connection.createStatement();
            resultSet =statement.executeQuery("Select * from Product");
            products =new ArrayList<Product>();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("productID"),
                        resultSet.getString("productName"),
                        resultSet.getInt("stockAmount"),
                        resultSet.getString("productCategory")));
            }

        } catch (SQLException exception) {
            System.out.println("Error : " + dBHelper.showErrorMessage(exception));
            System.out.println("error kodu :"+exception.getErrorCode());
        }
        finally{
            statement.close();
            connection.close();
        }
        return products;
    }


 
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        tbxID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        tbxName = new javax.swing.JTextField();
        lblAmaount = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        tbxCategory = new javax.swing.JTextField();
        tbxAmount = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Product name", "Stock amount", "product category"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setResizable(false);
            tblProduct.getColumnModel().getColumn(1).setResizable(false);
            tblProduct.getColumnModel().getColumn(2).setResizable(false);
            tblProduct.getColumnModel().getColumn(3).setResizable(false);
        }

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearch.setText("Arama :");

        tbxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxIDActionPerformed(evt);
            }
        });

        lblID.setBackground(new java.awt.Color(51, 51, 255));
        lblID.setText("Ürün id :");

        lblName.setBackground(new java.awt.Color(51, 51, 255));
        lblName.setText("Ürün adı :");

        lblAmaount.setBackground(new java.awt.Color(51, 51, 255));
        lblAmaount.setText("Ürün miktarı :");

        lblCategory.setBackground(new java.awt.Color(51, 51, 255));
        lblCategory.setText("Ürün kategorisi :");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnAdd.setText("Ekle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                                        .addComponent(lblAmaount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(tbxCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                                        .addComponent(tbxAmount)
                                                                        .addComponent(tbxName)
                                                                        .addComponent(tbxID)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tbxID)
                                                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tbxName)
                                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tbxAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblAmaount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter =new TableRowSorter<DefaultTableModel>(model);
        tblProduct.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }

    private void tbxIDActionPerformed(java.awt.event.ActionEvent evt) {
     
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        Connection connection = null;
        DBHelper dBHelper = new DBHelper();
        PreparedStatement statement =null;
        try {
            connection =dBHelper.getConnection();
            String sql = "insert into product(ID,ProductName,StockAmount,ProductCategory)values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(tbxID.getText()));
            statement.setString(2, tbxName.getText());
            statement.setInt(3, Integer.valueOf(tbxAmount.getText()));
            statement.setString(4, tbxCategory.getText());
           populateTable();
            int result = statement.executeUpdate();
        } catch (SQLException exception) {
            dBHelper.showErrorMessage(exception);
        }
        finally{
            try {
                statement.close();
                connection.close();
            }catch (SQLException exception){

            }

        }
    }

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new EmployeEnterance().setVisible(true);
        });
    }

  
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAmaount;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField tbxAmount;
    private javax.swing.JTextField tbxCategory;
    private javax.swing.JTextField tbxID;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField txtSearch;
   
}
