package com.sparta.astha.sakilaweb.controller;

import com.sparta.astha.Actor;
import com.sparta.astha.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller //for just creating web applications
@SessionAttributes("castList")//to scope this to the session of the controller
public class SakilaWebController {

    @Autowired
    private ActorRepository actorRepository;

//    @GetMapping("/sakila/cast/add/{id}")
//    public String addCastMember(@PathVariable int id, Model model,@ModelAttribute("castList")List<Actor> castList){
//        Actor actor=actorRepository.findById(id).get();
//        castList.add(actor);
//        System.out.println(castList);
//        return "displayCastList";
//
//    }

    @GetMapping("/sakila/cast/add/{id}")
    public String addCastMember(@PathVariable int id, @ModelAttribute("castList")List<Actor> castList){
        Actor actor=actorRepository.findById(id).get();
        castList.add(actor);
        System.out.println(castList);
        return "displayCastList";
    }


//
//    @ModelAttribute("castList")
//    public List<Actor> castList(){
//        return new ArrayList<Actor>();
//    }

    @ModelAttribute("castList")
    public List<Actor> castList(){
        System.out.println("initialisation");
        return new ArrayList<Actor>();
    }

    @GetMapping("/sakila/testname")
    public String testName(String nameParam, Model model){
        model.addAttribute("name", nameParam+" is adequate");
        return "displayName";//Name of template
    }

    @GetMapping("/sakila/actor")
    public String findActor(int id, Model model){
       // Actor result=actorRepository.findById(id).get();
        Optional<Actor> result=actorRepository.findById(id);
        Actor actor=null;
        if(result.isPresent()){
         actor= result.get();
        }
        model.addAttribute("actor",actor);
        return "displayActor";
    }

    @PostMapping("/sakila/actor/all")
    public String findAllActors(Model model){
    List<Actor> allActors = actorRepository.findAll();
    model.addAttribute("allActors",allActors);
    return "allActors";
}

    @GetMapping("/sakila/login")
    public String handleLogin(){
        return "login";
    }

  @GetMapping("/sakila/edit")
    public String displayActorEditForm(int id, Model model){
        Actor actor=actorRepository.findById(id).get();
        model.addAttribute("actorToEdit", actor);
        return "actorEditForm";

  }

  @PostMapping("/sakila/updateActor")
    public String updateActor(@ModelAttribute("actorToEdit") Actor actor){
      System.out.println(actor);
        actor.setLastUpdate(Instant.now());
        actorRepository.saveAndFlush(actor);
        return "editSuccess";
  }

  @GetMapping("/sakila/delete")
    public String deleteActor(int id){
        Actor actor=actorRepository.findById(id).get();
        actorRepository.delete(actor);
        return "actorDeleted";
  }



  @GetMapping("/sakila/createActor")
    public String createActor(Model model){
        Actor actor=new Actor();
        model.addAttribute("actorToCreate", actor);
        return "createActor";
  }

  @PostMapping("/sakila/createdSuccess")
        public String createdSuccessfully(@ModelAttribute("actorToCreate") Actor actor, Model model){
            actor.setLastUpdate(Instant.now());
            actorRepository.saveAndFlush(actor);
            Actor result=actorRepository.findById(actor.getId()).get();
            model.addAttribute("id",result.getId());
            return "createSuccess";
      }
  }


