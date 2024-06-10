package com.viajes.brayan.controller;

import com.viajes.brayan.entidades.Ruta;
import com.viajes.brayan.entidades.Usuario;
import com.viajes.brayan.service.RutaService;
import com.viajes.brayan.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private RutaService rutaService;

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute Usuario usuario, Model model) {
        Usuario usuarioEncontrado = usuarioService.buscarPorCorreo(usuario.getCorreo());
        if (usuarioEncontrado != null && usuarioEncontrado.getContraseña().equals(usuario.getContraseña())) {
            if (usuarioEncontrado.getCorreo().equals("admin@gmail.com")) {
                return "redirect:/dashboard?userId=" + usuarioEncontrado.getId();
            } else {
                model.addAttribute("userId", usuarioEncontrado.getId());
                return "redirect:/rutas/otra?userId=" + usuarioEncontrado.getId();
            }
        } else {
            return "redirect:/usuarios/login?error";
        }
    }



    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        // Redireccionar al formulario de inicio de sesión después de registrar un usuario
        return "redirect:/usuarios/login";
    }
    
    @PostMapping("/crear")
    public String registrarUsuario2(@ModelAttribute Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        // Redireccionar a la ruta "/usuarios/users" después de registrar un usuario
        return "redirect:/usuarios/users";
    }

    
    
    @GetMapping("/crear")
	public String loginAdm(Model model) {
		return "crear";
	}

    @GetMapping("/users")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosLosUsuarios());
        return "lista_usuarios";
    }
    
   

   

    
    
    
   

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            model.addAttribute("usuario", usuario);
            return "editar_usuario";
        } else {
            // Manejo de error si el usuario no existe
            return "redirect:/usuarios/users";
        }
    }
    
    
    

    @PostMapping("/editar/{id}")
    public String actualizarUsuario(@PathVariable String id, @ModelAttribute ("usuario") @Valid Usuario usuario) {
        usuario.setId(id); // Asegúrate de establecer el ID del usuario
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/usuarios/users";
    }


    
   
   

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String  id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios/users";
    }
   
}

