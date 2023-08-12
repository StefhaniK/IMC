package com.calculadora.IMC.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_IMC {
    @GetMapping("/")
    public String landPage(){
        return "index";
    }

    @PostMapping("/")
    public String postIMC(@RequestParam("altura") String altura,@RequestParam("peso") String peso){
        return "index";
    }
    public class ImcController {

        @GetMapping("/calcular-imc")
        public String calcularIMC(
                @RequestParam(name = "peso") double peso,
                @RequestParam(name = "altura") double altura,
                Model model
        ) {
            double imc = calcularIMC(peso, altura);
            String mensaje;

            if (imc < 18.5) {
                mensaje = "Bajo peso";
            } else if (imc < 24.9) {
                mensaje = "Peso normal";
            } else if (imc < 29.9) {
                mensaje = "Sobrepeso";
            } else {
                mensaje = "Obesidad";
            }

            model.addAttribute("imc", imc);
            model.addAttribute("mensaje", mensaje);

            return "resultado-imc"; // Nombre de la plantilla Thymeleaf para mostrar resultados
        }

        private double calcularIMC(double peso, double altura) {
            return peso / (altura * altura);
        }




}
