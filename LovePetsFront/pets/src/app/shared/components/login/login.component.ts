import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UsesrServiceService } from '../../../user/services/user-service/usesr-service.service';
import { UserLogin } from '../../../shared/models/user-login';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  secondPartQuestions: FormGroup;
  email: string;
  password: string;

  constructor(private userServiceService: UsesrServiceService) {}

  ngOnInit(): void {}

  submit(): void {
    var newUser: UserLogin = { password: this.password, username: this.email };
    this.userServiceService.login(newUser).subscribe((res) => {
      console.log(res);
    });
  }
}
