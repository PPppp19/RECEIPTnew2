/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.api.data;

import com.br.api.connect.ConnectDB2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;

/**
 *
 * @author Jilasak
 */
public class UpdateDB2 {

    public static String DBPRD = GBVAR.DBPRD;
//        public static String DBPRD = "M3FDBTST";

    public static void Update_Line(String LR_CONO, String LR_DIVI, String LR_RCNO, String LR_INVNO, String LR_REAMT) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
                LR_REAMT = new DecimalFormat("0.00").format(Double.parseDouble(LR_REAMT.replaceAll(",", "").trim()));

                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".LR_LINERECEIPT\n"
                        + "SET LR_REAMT = '" + LR_REAMT + "'\n"
                        + "WHERE LR_CONO = '" + LR_CONO.trim() + "' AND LR_DIVI='" + LR_DIVI.trim() + "' AND LR_RCNO='" + LR_RCNO + "' AND LR_INVNO = '" + LR_INVNO.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void Update_Status(int CONO, String DIVI, String RCNO, String STS, String TYPE) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                String query = "";
                if (TYPE.equalsIgnoreCase("Rollback")) {
                    query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                            + "SET HC_STS = '" + STS.trim() + "'\n"
                            + "WHERE HC_RCNO = '" + RCNO.trim() + "' \n"
                            + "AND HC_STS = '2' AND HR_CONO = '" + CONO + "' AND HR_DIVI = '" + DIVI.trim() + "'";
                } else if (TYPE.equalsIgnoreCase("Cancel")) {
                    query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                            + "SET HC_STS = '" + STS.trim() + "'\n"
                            + "WHERE HC_RCNO = '" + RCNO.trim() + "' \n"
                            + "AND HR_CONO = '" + CONO + "' AND HR_DIVI = '" + DIVI.trim() + "'";

                } else if (TYPE.equalsIgnoreCase("PRINT")) {
                    query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                            + "SET HC_STS = '" + STS.trim() + "'\n"
                            + "WHERE HC_RCNO = '" + RCNO.trim() + "' \n"
                            + "AND HR_CONO = '" + CONO + "' AND HR_DIVI = '" + DIVI.trim() + "'";
                }

//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void UpdateHeader(String HR_CONO, String HR_DIVI, String HC_PYNO, String HC_REAMT, String HC_TYPE, String HC_PYDT, String HC_CHKNO, String HC_BANK, String HC_ACCODE, String HR_BKCHG, String HR_RCNO) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
//                LR_REAMT = new DecimalFormat("0.00").format(Double.parseDouble(LR_REAMT.replaceAll(",", "").trim()));
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        //                String query = "UPDATE BRLDTA0100.HR_RECEIPTV2\n"
                        + "SET HC_PYNO = '" + HC_PYNO.trim() + "', HC_REAMT = '" + HC_REAMT.trim() + "',HC_TYPE = '" + HC_TYPE.trim() + "',HC_PYDT = '" + HC_PYDT.replaceAll("-", "").trim() + "',HC_CHKNO = '" + HC_CHKNO.trim() + "',"
                        + " HC_BANK = '" + HC_BANK.trim() + "', HC_ACCODE = '" + HC_ACCODE.trim() + "',HR_BKCHG = '" + HR_BKCHG.trim() + "'\n"
                        + "WHERE HR_CONO = '" + HR_CONO.trim() + "' AND HR_DIVI='" + HR_DIVI.trim() + "' AND HC_RCNO='" + HR_RCNO.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void UpdateHeaderExpense(String HR_CONO, String HR_DIVI, String HC_PYNO, String HC_REAMT, String HC_TYPE, String HC_PYDT, String HC_CHKNO, String HC_BANK, String HC_ACCODE, String HR_BKCHG, String HR_RCNO, String HC_USER) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
//                LR_REAMT = new DecimalFormat("0.00").format(Double.parseDouble(LR_REAMT.replaceAll(",", "").trim()));
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        //                String query = "UPDATE BRLDTA0100.HR_RECEIPTV2\n"
                        + "SET HC_PYNO = '" + HC_PYNO.trim() + "', HC_REAMT = '" + HC_REAMT.trim() + "',HC_TYPE = '" + HC_TYPE.trim() + "',HC_PYDT = '" + HC_PYDT.replaceAll("-", "").trim() + "',HC_CHKNO = '" + HC_CHKNO.trim() + "',"
                        + " HC_BANK = '" + HC_BANK.trim() + "', HC_ACCODE = '" + HC_ACCODE.trim() + "',HR_BKCHG = '" + HR_BKCHG.trim() + "' , HC_USER = '" + HC_USER.trim() + "'\n"
                        + "WHERE HR_CONO = '" + HR_CONO.trim() + "' AND HR_DIVI='" + HR_DIVI.trim() + "' AND HC_RCNO='" + HR_RCNO.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void UpdateHeaderDEPOSIT(String HR_CONO, String HR_DIVI, String HC_PYNO, String HC_REAMT, String HC_TYPE, String HC_PYDT, String HC_CHKNO, String HC_BANK, String HC_ACCODE, String HR_BKCHG, String HR_RCNO, String HC_USER) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
//                LR_REAMT = new DecimalFormat("0.00").format(Double.parseDouble(LR_REAMT.replaceAll(",", "").trim()));
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        //                String query = "UPDATE BRLDTA0100.HR_RECEIPTV2\n"
                        + "SET HC_PYNO = '" + HC_PYNO.trim() + "', HC_REAMT = '" + HC_REAMT.trim() + "',HC_TYPE = '" + HC_TYPE.trim() + "',HC_PYDT = '" + HC_PYDT.replaceAll("-", "").trim() + "',HC_CHKNO = '" + HC_CHKNO.trim() + "',"
                        + " HC_BANK = '" + HC_BANK.trim() + "', HC_ACCODE = '" + HC_ACCODE.trim() + "',HR_BKCHG = '" + HR_BKCHG.trim() + "' , HC_USER = '" + HC_USER.trim() + "'\n"
                        + "WHERE HR_CONO = '" + HR_CONO.trim() + "' AND HR_DIVI='" + HR_DIVI.trim() + "' AND HC_RCNO='" + HR_RCNO.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void Update_LineClearExpense(String LREP_CONO, String LREP_DIVI, String LREP_RCNO, String LREP_INVNO, String LREP_EXPAMT) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
                LREP_EXPAMT = new DecimalFormat("0.00").format(Double.parseDouble(LREP_EXPAMT.replaceAll(",", "").trim()));

                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".LR_LINECLEAREXP\n"
                        + "SET LREP_EXPAMT = '" + LREP_EXPAMT.trim() + "'\n"
                        + "WHERE LREP_CONO = '" + LREP_CONO.trim() + "' AND LREP_DIVI = '" + LREP_DIVI.trim() + "' AND LREP_RCNO = '" + LREP_RCNO.trim() + "' "
                        + " AND LREP_INVNO = '" + LREP_INVNO.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void Update_Receiver(String CONO, String DIVI, String RCNO, String TYPE, String RECEIVER) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".RECEIPT_RECEIVER\n"
                        + "SET RR_DESC = '" + RECEIVER.trim() + "' , RR_TYPE = '" + TYPE.trim() + "' \n"
                        + "WHERE RR_CONO = '" + CONO.trim() + "' AND RR_DIVI = '" + DIVI.trim() + "' AND RR_RCNO = '" + RCNO.trim() + "' ";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void Update_SeriesReceipt(String RR_CONO, String RR_DIVI, String RR_LCCODE, String RR_USER, String RR_START, String RR_END, String RR_COUNT) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".RECEIPT_RUNNING\n"
                        + "SET RR_START = '" + RR_START.trim() + "', RR_END = '" + RR_END.trim() + "', RR_COUNT = '" + RR_COUNT.trim() + "' \n"
                        + "WHERE RR_CONO='" + RR_CONO.trim() + "' AND RR_DIVI='" + RR_DIVI.trim() + "' AND RR_LCCODE='" + RR_LCCODE.trim() + "' AND RR_USER='" + RR_USER.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void Update_Running_Fix(String CONO, String DIVI, String RCNO, String LOCATION, String Fix_Running) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        + "SET HC_FIXNO = '" + Fix_Running.trim() + "'\n"
                        + "WHERE HR_CONO = '" + CONO.trim() + "'\n"
                        + "AND HR_DIVI = '" + DIVI.trim() + "'\n"
                        + "AND HC_RCNO = '" + RCNO.trim() + "'\n"
                        //                        + "AND HC_VCNO = '" + VCNO.trim() + "'\n"
                        + "AND HC_LOCATION = '" + LOCATION.trim() + "'";
//                System.out.println("Update_Running_Fix\n" + query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void Update_Running_Master(String CONO, String DIVI, String LOCATION, String Fix_Running, String USER, String RCNO) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
                int row_count = SelectDB2.FindUserPagePaper(CONO, DIVI, RCNO);

                int P1 = row_count / 10;
                int P2 = row_count % 10;
                if (P2 != 0) {
                    P2 = 1;
                }
                int Page = P1 + P2;

                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".RECEIPT_RUNNING\n"
                        //                        + "SET  RR_COUNT =  TRIM(TO_CHAR(RR_COUNT+" + Page + ",'0000000')) \n"
                        + "SET  RR_COUNT = TRIM(TO_CHAR(SUBSTRING(RR_COUNT,1,3))) || TRIM(TO_CHAR(SUBSTRING(RR_COUNT,4) + " + Page + ",'0000')) \n"
                        + "WHERE RR_CONO = '" + CONO.trim() + "' AND RR_DIVI = '" + DIVI.trim() + "' AND RR_LCCODE = '" + LOCATION.trim() + "' \n"
                        //                        + "AND RR_USER = '" + USER.trim() + "' AND RR_COUNT = '" + Fix_Running.trim() + "' ";
                        + "AND RR_USER = '" + USER.trim() + "' ";

//                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void UpdateCancel(String cono, String divi, String rcno, String reason, String action, String app1, String app2) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".RECEIPT_CANCEL\n"
                        + "SET RC_REASON='" + reason.trim() + "', RC_ACTION='" + action.trim() + "', RC_APP1='" + app1.trim() + "', RC_APP2='" + app2.trim() + "', "
                        + "RC_APPNOW = '" + app1.trim() + "', RC_STS='20'\n"
                        + "WHERE RC_CONO = '" + cono.trim() + "' AND RC_DIVI = '" + divi.trim() + "' AND RC_RCNO = '" + rcno.trim() + "' ";
                stmt.execute(query);
            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void updateRequester(String cono, String divi, String rcno, String user) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        + "SET HC_USER='" + user.trim() + "'\n"
                        + "where HR_CONO = '" + cono.trim() + "'\n"
                        + "and HR_DIVI = '" + divi.trim() + "'\n"
                        + "and HC_RCNO = '" + rcno.trim() + "'";
//                System.out.println(query);
                stmt.execute(query);
            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void UpdateTransactionDate(String HR_CONO, String HR_DIVI, String HC_TRDT, String HC_RCNO, String BANK, String LCODE) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();

        try {
            if (conn != null) {
//                LR_REAMT = new DecimalFormat("0.00").format(Double.parseDouble(LR_REAMT.replaceAll(",", "").trim()));
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        + "SET HC_BANK = '" + BANK.trim() + "',HC_ACCODE = '" + LCODE.trim() + "' ,HC_TRDT = '" + HC_TRDT.replaceAll("-", "").trim() + "' \n"
                        + "WHERE HR_CONO = '" + HR_CONO.trim() + "' AND HR_DIVI = '" + HR_DIVI.trim() + "' AND HC_RCNO = '" + HC_RCNO.trim() + "'";
                System.out.println(query);
                stmt.execute(query);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static void UpdateTransactionDatenew(String HR_CONO, String HR_DIVI, String HC_TRDT, String HC_RCNO, String BANK, String LCODE, String HR_BKCHG, String FNNO, String AMT) throws Exception {

        Connection conn = ConnectDB2.ConnectionDB();
        Double Amt_Include_BKCHG = Double.parseDouble(AMT) + Double.parseDouble(HR_BKCHG);

        try {
            if (conn != null) {
//                LR_REAMT = new DecimalFormat("0.00").format(Double.parseDouble(LR_REAMT.replaceAll(",", "").trim()));
                Statement stmt = conn.createStatement();
                String query = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        + "SET HC_BANK = '" + BANK.trim() + "', HR_BKCHG = '" + HR_BKCHG + "' ,HC_ACCODE = '" + LCODE.trim() + "' ,HC_TRDT = '" + HC_TRDT.replaceAll("-", "").trim() + "' \n"
                        + "WHERE HR_CONO = '" + HR_CONO.trim() + "' AND HR_DIVI = '" + HR_DIVI.trim() + "' AND HC_RCNO = '" + HC_RCNO.trim() + "'";
                System.out.println(query);
                stmt.execute(query);

                Statement stmt2 = conn.createStatement();
                String query2 = "UPDATE " + DBPRD + ".HR_RECEIPT\n"
                        + "SET HR_BKCHG = '" + HR_BKCHG + "' ,  HC_REAMT = '"+Amt_Include_BKCHG+"' \n"
                        + "WHERE HR_CONO = '" + HR_CONO.trim() + "' AND HR_DIVI = '" + HR_DIVI.trim() + "' AND HC_FNNO = '" + FNNO.trim() + "'";
                System.out.println(query2);
                stmt.execute(query2);

                Statement stmt3 = conn.createStatement();
                String query3 = "UPDATE " + DBPRD + ".BANK_MAPPING\n"
                        + "SET BM_BKCHARGE = '" + HR_BKCHG + "'  \n"
                        + "WHERE BM_CONO = '" + HR_CONO.trim() + "' AND BM_DIVI = '" + HR_DIVI.trim() + "' AND BM_FNNO = '" + FNNO.trim() + "'";
                System.out.println(query3);
                stmt.execute(query3);

            } else {
                System.out.println("Server can't connect.");
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

}
