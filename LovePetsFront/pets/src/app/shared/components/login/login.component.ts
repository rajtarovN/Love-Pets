import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UsesrServiceService } from '../../../user/services/user-service/usesr-service.service';
import { UserLogin } from '../../../shared/models/user-login';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  secondPartQuestions: FormGroup;
  email: string;
  password: string;

  constructor(
    private userServiceService: UsesrServiceService,
    private fb: FormBuilder,
    public router: Router
  ) {}

  ngOnInit(): void {
    this.secondPartQuestions = this.fb.group({
      name: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  submit(): void {
    var newUser: UserLogin = { password: this.password, username: this.email };
    this.userServiceService.login(newUser).subscribe((res) => {
      console.log(res);
      if (res != null) {
        localStorage.setItem('username', res.username);
        this.router.navigate(['/pet-view']);
      }
    });
  }
}
