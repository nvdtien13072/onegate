package com.example.demo.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/welcome")
    public String greeting(Model model) throws IOException {
        try (final WebClient webClient = new WebClient()) {

            // Get the first page
            final HtmlPage page1 = webClient.getPage("http://motcua.codo.cantho.gov.vn");

            List<HtmlForm> listForm =  page1.getForms();


//            final HtmlForm form = page1.getFormByName("_58_fm");
            System.out.println(listForm.size());
            listForm.forEach(list-> {
                System.out.println(list );
            });
//            model.addAttribute("name", listForm.get(0).);
//            final HtmlSubmitInput button = form.getInputByName("submitbutton");
//            final HtmlTextInput textField = form.getInputByName("userid");
//
//            // Change the value of the text field
//            textField.type("root");
//
//            // Now submit the form by clicking the button and get back the second page.
//            final HtmlPage page2 = button.click();
        }


        return "welcome";
    }

}
