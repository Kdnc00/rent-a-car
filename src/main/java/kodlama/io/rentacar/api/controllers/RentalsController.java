package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.RentalService;
import kodlama.io.rentacar.business.dto.requests.create.CreateRentalRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateRentalRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateRentalResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllRentalResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetRentalResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private final RentalService rentalService;
    @GetMapping
    public List<GetAllRentalResponse>getAll(){
        return rentalService.gelAll();
    }
    @GetMapping("/{id}")
    public GetRentalResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponse add(@RequestBody CreateRentalRequest request){
        return rentalService.add(request);
    }
    @PutMapping("/{id}")
    public UpdateRentalResponse update(@PathVariable int id,@RequestBody UpdateRentalRequest request){
        return rentalService.update(id,request);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id){
        rentalService.delete(id);
    }

}
