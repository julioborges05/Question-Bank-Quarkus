create sequence if not exists question_id_seq;

create table if not exists question(
    id bigint not null default nextVal('question_id_seq'),
    question varchar not null,
    correct_answer varchar not null,
    wrong_answer1 varchar not null,
    wrong_answer2 varchar not null,
    wrong_answer3 varchar not null,
    constraint question_pkey primary key (id)
);