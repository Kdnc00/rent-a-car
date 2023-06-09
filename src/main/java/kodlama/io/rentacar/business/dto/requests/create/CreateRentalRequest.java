package kodlama.io.rentacar.business.dto.requests.create;

import kodlama.io.rentacar.business.dto.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    //kart bilgileri
    private PaymentRequest paymentRequest;
}
