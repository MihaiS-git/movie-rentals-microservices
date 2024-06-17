export interface Rental {
  id: number;
  movieId: number;
  clientId: number;
  amount: number;
  discount: number;
  rentDate: Date;
  duration: number;
  dueDate: Date;
}
