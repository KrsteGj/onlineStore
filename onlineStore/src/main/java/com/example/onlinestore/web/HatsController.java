package com.example.onlinestore.web;

import com.example.onlinestore.model.BrandType;
import com.example.onlinestore.model.Hat;
import com.example.onlinestore.model.StoreLocation;
import com.example.onlinestore.service.HatService;
import com.example.onlinestore.service.StoreLocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HatsController {
    private final HatService hatService;
    private final StoreLocationService storeLocationService;

    public HatsController(HatService hatService, StoreLocationService storeLocationService) {
        this.hatService = hatService;
        this.storeLocationService = storeLocationService;
    }

    @GetMapping("/hats")
    public String showHats(@RequestParam(required = false)Double price,
                           @RequestParam(required = false)BrandType type,
                           Model model)
    {
        List<Hat> hat;
        List<StoreLocation> storeLocation  = this.storeLocationService.listAll();
        if (price == null && type == null) {
            hat = this.hatService.listAllHats();
        } else {
            hat = this.hatService.listMatchesWithPriceLessThanAndType(price, type);
        }
        model.addAttribute("hat", hat);
        model.addAttribute("storeLocation",storeLocation);
        model.addAttribute("type", BrandType.values());
        return "list.html";
    }

    @GetMapping("/hats/add")
    public String showAdd(Model model) {
        List<StoreLocation> storeLocation  = this.storeLocationService.listAll();
        model.addAttribute("storeLocation", storeLocation);
        model.addAttribute("type", BrandType.values());
        return "form.html";
    }

    @GetMapping("/hats/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Hat hat = this.hatService.findById(id);
        List<StoreLocation> storeLocation  = this.storeLocationService.listAll();
        model.addAttribute("hat", hat);
        model.addAttribute("location",storeLocation);
        model.addAttribute("type", BrandType.values());
        return "form.html";
    }

    @PostMapping("/hats")
    public String create(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam Double price,
                         @RequestParam BrandType type,
                         @RequestParam Long location) {
        this.hatService.create(name, description, price, type, location);
        return "redirect:/hats";
    }

    @PostMapping("/hats/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam Double price,
                         @RequestParam BrandType type,
                         @RequestParam Long location) {
        this.hatService.update(id, name, description, price, type, location);
        return "redirect:/hats";
    }

    @PostMapping("hats/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.hatService.delete(id);
        return "redirect:/hats";
    }

}
