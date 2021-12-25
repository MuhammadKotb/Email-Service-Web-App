"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.InboxComponent = void 0;
var core_1 = require("@angular/core");
var InboxComponent = /** @class */ (function () {
    function InboxComponent() {
        this.listOfEmails = [];
        this.viewArray = [];
    }
    InboxComponent.prototype.ngOnInit = function () {
        var x = {
            senderUsername: "Joe",
            timeSent: "27/9/2001",
            subject: "birthday",
            body: '',
            owner: '',
            recieverUsername: '',
            emailID: '',
            emailType: '',
            priority: 'Urgent'
        };
        var y = {
            senderUsername: "Meniem",
            timeSent: "4/6/2001",
            subject: "birthday",
            body: '',
            owner: '',
            recieverUsername: '',
            emailID: '',
            emailType: '',
            priority: 'Important'
        };
        var Z = {
            senderUsername: "otb",
            timeSent: "هيخو",
            subject: "birthday",
            body: '',
            owner: '',
            recieverUsername: '',
            emailID: '',
            emailType: '',
            priority: 'Non-essential'
        };
        this.listOfEmails.push(x);
        this.listOfEmails.push(y);
        this.listOfEmails.push(Z);
        this.parseArray();
        for (var i = 0; i < this.viewArray[0].length; i++) {
            var node = document.createElement("tr");
            for (var j = 0; j < 5; j++) {
                var node2 = document.createElement("td");
                if (j != 4) {
                    var textNode = document.createTextNode(this.viewArray[i][j]);
                    node2.appendChild(textNode);
                }
                else {
                    var node3 = document.createElement("button");
                    var textNode = document.createTextNode("Show");
                    node3.appendChild(textNode);
                    node2.appendChild(node3);
                    textNode = document.createTextNode("Delete");
                    var node4 = document.createElement("button");
                    node4.appendChild(textNode);
                    node2.appendChild(node4);
                }
                node.appendChild(node2);
            }
            document.getElementById("mybody").appendChild(node);
        }
    };
    InboxComponent.prototype.parseArray = function () {
        for (var email = 0; email < this.listOfEmails.length; email++) {
            this.viewArray[email] = [];
            this.viewArray[email][0] = this.listOfEmails[email].senderUsername;
            this.viewArray[email][1] = this.listOfEmails[email].timeSent;
            this.viewArray[email][2] = this.listOfEmails[email].subject;
            this.viewArray[email][3] = this.listOfEmails[email].priority;
        }
    };
    InboxComponent = __decorate([
        core_1.Component({
            selector: 'app-inbox',
            templateUrl: './inbox.component.html',
            styleUrls: ['./inbox.component.css']
        })
    ], InboxComponent);
    return InboxComponent;
}());
exports.InboxComponent = InboxComponent;
