package bd.edu.seu.libraryms.report.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @GetMapping
    public String showReport(
            @RequestParam(value = "startDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,

            @RequestParam(value = "endDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,

            Model model
    ) {

        // default date range: last 2 days (just for demo)
        if (startDate == null) {
            startDate = LocalDate.now().minusDays(1);
        }
        if (endDate == null) {
            endDate = LocalDate.now();
        }

        //  Dummy summary data (later repo theke asbe )
        double totalPurchase = 296523.00;
        double totalFine = 0.0;
        double totalAllotment = 500.00;
        int bookReceiveCount = 1;

        //  Dummy table rows (Book Allotment tab)
        List<BookAllotmentRow> allotmentRows = new ArrayList<>();

        BookAllotmentRow r1 = new BookAllotmentRow();
        r1.setBookName("CPP");
        r1.setStudentName("Pradeep");
        r1.setStudentEmail("Pradeep@gmail.com");
        r1.setQuantity(1);
        r1.setTotalAmount(500.00);

        allotmentRows.add(r1);

        // model attributes
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        model.addAttribute("totalPurchase", totalPurchase);
        model.addAttribute("totalFine", totalFine);
        model.addAttribute("totalAllotment", totalAllotment);
        model.addAttribute("bookReceiveCount", bookReceiveCount);

        model.addAttribute("allotmentRows", allotmentRows);

        return "report/list";
    }

    // simple inner DTO for table (only for report UI)
    public static class BookAllotmentRow {
        private String bookName;
        private String studentName;
        private String studentEmail;
        private int quantity;
        private double totalAmount;

        public String getBookName() { return bookName; }
        public void setBookName(String bookName) { this.bookName = bookName; }

        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }

        public String getStudentEmail() { return studentEmail; }
        public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public double getTotalAmount() { return totalAmount; }
        public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    }
}
