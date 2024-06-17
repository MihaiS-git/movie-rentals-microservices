import { Component, OnInit } from '@angular/core';
import { Rental } from '../../model/rental.model';
import { RentalService } from '../../service/rental.service';
import { Router } from '@angular/router';

@Component({
  selector: 'rental-list',
  templateUrl: './rental-list.component.html',
  styleUrls: ['./rental-list.component.css']
})
export class RentalListComponent implements OnInit {
  errorMessage: string = "";
  rentals: Array<Rental> = [];
  displayedRentals: Array<Rental> = [];
  selectedRental: Rental | undefined;
  searchedClientId: number = 0;

  constructor(private rentalService: RentalService,
    private router: Router) {

  }

  ngOnInit(): void {
    this.rentalService.getRentals().subscribe((data: any) => {
      this.rentals = data;
      this.displayedRentals = data;
    });
  }

  onSelect(rental: Rental): void {
    this.selectedRental = rental;
  }

  gotoDetail(): void {
    this.router.navigate(['/rental/detail', this.selectedRental?.id]);
  }

  deleteRental(): void {
    if (this.selectedRental) {
      this.rentalService.delete(this.selectedRental.id).subscribe({
        next: () => {
          this.rentals = this.rentals.filter(
            (rental) => rental.id !== this.selectedRental?.id
          );
          this.displayedRentals = this.displayedRentals.filter(
            (rental) => rental.id !== this.selectedRental?.id
          );
          this.selectedRental = undefined;
        },
        error: (err: any) => {
          console.error("Error deleting rental: ", err);
        },
        complete: () => { },
      });
    }
  }

  addNewRental(): void {
    this.router.navigate(['/rental/detail', 'new']);
  }

  sortRentalsOrderedByDateAsc() {
    this.displayedRentals.sort((a, b) => {
      const dateA = new Date(a.rentDate).getTime();
      const dateB = new Date(b.rentDate).getTime();
      return dateA - dateB;
    })
  }

  sortRentalsOrderedByDateDesc() {
    this.displayedRentals.sort((a, b) => {
      const dateA = new Date(a.rentDate).getTime();
      const dateB = new Date(b.rentDate).getTime();
      return dateB - dateA;
    })
  }

  findRentalsByClientId(searchedClientId: number) {
    const filteredRentals = this.rentals.filter(rental =>
      rental.clientId == searchedClientId
    );
    this.displayedRentals = filteredRentals;
  }

  resetFilter() {
    this.searchedClientId = 0;
    this.displayedRentals = this.rentals;
  }
}
