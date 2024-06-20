## SSH key
### generate ssh key
ssh-keygen -t {key_type} -C "your_email@example.com"

## Git Branch
### create a new branch
git checkout -b {new_branch_name}

### push a new branch to remote repo
git push origin {new_branch_name}

### current local branch relate to remote branch
git branch --set-upstream-to=origin/{new_branch_name}

### push a new branch to remote repo and current local branch relate to remote branch
git push --set-upstream origin {new_branch_name}

### current local branch un-relate to remote branch
git branch --unset-upstream

### show local branch and remote branch mapping
git branch -vv

### change branch name
git branch -m {new_branch_name}

### delete a branch
git branch -d {branch_name}

### force delete a branch
git branch -D {branch_name}

### delete a remote branch
git push --delete origin {branch_name}

Note: when you want to delete a branch(local & remote), you need to switch to another branch first,
you cannot delete current branch

### switch to last branch
git checkout -

### update remote branch changes to local
git remote prune origin

### to show when a branch was created
git reflog show --date-iso {branch_name}

## Update
### discard all changes
git checkout -- .

### discard specify changes
git checkout -- {the_file_you_want_to_discard}

### roll back add operation
git rm -r --cached {the_file_you_want_to_roll_back}

### roll back add operation for all (revoke git add .)
git reset HEAD

### change the last commit message
git commit -amend 
execute the above command and then can edit commit message

## Merge
### merge another branch to current branch
git merge {source_branch}
eg. git merge master -- means to merge master branch to current branch

## Resolve Conflict
### conflict happens after merge, if you want to discard all conflicts what you have change and keep other's changes
git checkout {conflict_file} --theirs

### conflict happens after merge, if you want to keep all conflicts what you have changed but discard other's changes
git checkout {conflict_file} --ours

## Stash
### show stash list
git stash list

### save stash
1. git add .
2. git stash save 'your_save_massage' 

### apply stash but not delete from stash list
git stash apply {your_stash_no}

### apply stash and delete from stash list
git stash pop {your_stash_no}

### delete a stash from stash list
git stash drop {your_stash_no}

### clear stash list
git stash clear

## Roll back
### roll back to last version
git reset --hard HEAD^

### roll back to the No.n commit
git reset --hard HEAD~{n}
eg. git reset --hard HEAD~5

### roll back to specify commit
git reset --head {commit_id}

### force push to remote repo (after you roll back, you may need this)
git push origin HEAD --force

## Repository
### show remote repo
git remote -v

### un-relate to remote repo
git remote rm origin

### relate to remote repo (1) (update remote origin url)
git remote set-url origin {repo_url} (repo_url means clone url)

### relate to remote repo (2)
git remote add origin {repo_url}

Note: If get error when relate to remote repo directly(1), 
then un-relate to remote repo first and then add to new remote repo(2)
if get error like: fatal: refusing to merge unrelated histories, then execute below command

git pull origin {branch_name} --allow-unrelate-histories

## Fatal: Note possible to fast-forward, aborting
### Get the above issue may because conflict between origin and local repo, follow below step
git pull origin {branch_name}
git merge origin {branch_name}
git pull origin {branch_name}
git push origin {branch_name}

### A Risk way to handle the issue
git pull origin {your_current_branch} --rebase

## Clear historical commit and initialize the repo
git checkout --orphan {new_branch_name}
git add -A
git commit -am "{your_commit_message}"
git push --set-upstream origin {new_branch_name}




