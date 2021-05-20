package faber.app.flightapp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import faber.app.flightapp.entity.Order;
import faber.app.flightapp.repository.OrderRepository;

/**
 * OrderController
 *
 * @author TuanAnh
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    MessageSource messageSource;

    /**
     * initScreen
     *
     * @param model
     * @return returnPage
     */
    @RequestMapping(method = RequestMethod.GET)
    private String initScreen(Model model) {

        model.addAttribute("orderList", orderRepository.findAll());
        return "order";
    }

    /**
     * registerOrder
     *
     * @param list
     * @param model
     * @return returnPage
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerOrder(@RequestBody List<Order> list, Model model) {
        Map<String, Object> response = new HashMap<String, Object>();
        String modalMessage = "";

        try {
            // save order
            for (Order order : list) {
                order.setTimeOfOrder(new Date());
                orderRepository.save(order);
            }

            // return message Success
            modalMessage = "Success";
            response.put("modalMessage", modalMessage);
            response.put("list", list);
        } catch (Exception e) {
            // return message failed
            modalMessage = "Registration failed";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(modalMessage);
        }
        return ResponseEntity.ok(response);
    }
}
